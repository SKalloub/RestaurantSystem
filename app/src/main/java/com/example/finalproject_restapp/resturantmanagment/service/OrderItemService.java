package com.example.finalproject_restapp.resturantmanagment.service;

import com.example.finalproject_restapp.resturantmanagment.model.OrderItem;
import com.example.finalproject_restapp.resturantmanagment.resource.OrderItemRes;
import com.example.finalproject_restapp.resturantmanagment.resource.repository.OrderItemRepository;

import java.util.List;

public class OrderItemService {
    private static OrderItemRepository orderItemRepository = OrderItemRes.getInstance();
    public static void addItems(List<OrderItem>items){
        for (OrderItem item : items) {
            orderItemRepository.add(item);
        }
    }
}
