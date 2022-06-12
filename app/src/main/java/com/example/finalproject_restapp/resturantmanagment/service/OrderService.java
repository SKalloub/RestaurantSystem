package com.example.finalproject_restapp.resturantmanagment.service;

import com.example.finalproject_restapp.resturantmanagment.dto.ItemDto;
import com.example.finalproject_restapp.resturantmanagment.dto.OrderDto;
import com.example.finalproject_restapp.resturantmanagment.model.Customer;
import com.example.finalproject_restapp.resturantmanagment.model.Item;
import com.example.finalproject_restapp.resturantmanagment.model.Order;
import com.example.finalproject_restapp.resturantmanagment.model.OrderItem;
import com.example.finalproject_restapp.resturantmanagment.model.enums.STATUS;

import com.example.finalproject_restapp.resturantmanagment.resource.CustomerRes;
import com.example.finalproject_restapp.resturantmanagment.resource.EmployeeRes;
import com.example.finalproject_restapp.resturantmanagment.resource.OrderItemRes;
import com.example.finalproject_restapp.resturantmanagment.resource.OrderRes;
import com.example.finalproject_restapp.resturantmanagment.resource.repository.CustomerRepository;
import com.example.finalproject_restapp.resturantmanagment.resource.repository.EmployeeRepository;
import com.example.finalproject_restapp.resturantmanagment.resource.repository.OrderItemRepository;
import com.example.finalproject_restapp.resturantmanagment.resource.repository.OrderRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderService {

    private static OrderRepository orderRepository = OrderRes.getInstance();
    private static OrderItemRepository orderItemRepository = OrderItemRes.getInstance();
    private static CustomerRepository customerRepository = CustomerRes.getInstance();
    public static Order addOrder(List<Item> items, Customer customer) {
        return addOrder(items, customer, false);
    }

    public static Order addOrder(List<Item> items, Customer customer, boolean out) {
        Order order = new Order();
        order.setCustomerId(customer.getId());
        order.setStatus(STATUS.WAITING);
        order.setOutside(out);
        order = orderRepository.addOrder(order);

        HashMap<Item, Integer> itemsMap = new HashMap<>();
        HashMap<Item, OrderItem> orderItems = new HashMap<>();
        for (Item item : items) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrderId(order.getId());
            orderItem.setItemId(item.getId());
            if (!itemsMap.containsKey(item)) {
                itemsMap.put(item, 1);
                orderItem.setQuantity(1);
            } else {
                itemsMap.put(item, itemsMap.get(item) + 1);
                orderItem.setQuantity(itemsMap.get(item));
            }
            orderItem.setPrice(item.getPrice() * orderItem.getQuantity());
            orderItems.put(item, orderItem);
        }
        List<OrderItem> list = new ArrayList<>();
        for (Map.Entry<Item, OrderItem> entry : orderItems.entrySet()) {
            Item k = entry.getKey();
            OrderItem v = entry.getValue();
            list.add(v);
        }

        OrderItemService.addItems(list);
        return order;
    }

    public static List<OrderDto> getAllOrders() {
        List<OrderDto> list = new ArrayList<>();
        for (Order order : orderRepository.getOrders()) {
            OrderDto dto = new OrderDto();
            dto.setOrderId(order.getId());
            dto.setCustomerName(customerRepository.findById(order.getCustomerId()).getName());
            dto.setStatus(order.getStatus());
            dto.setItems(orderItemRepository.getItemsByOrderId(order.getId()));
            list.add(dto);
        }
        return list;
    }

    public static ArrayList<String> ordersReport() {
        ArrayList<String> arr = new ArrayList<>();
        int total = 0;
        for (OrderDto allOrder : OrderService.getAllOrders()) {
            arr.add(allOrder.toString());
            for (ItemDto item : allOrder.getItems()) {
                total += item.getPrice();
            }
        }
        arr.add("Total = " + total + " $");
        return arr;
    }

}
