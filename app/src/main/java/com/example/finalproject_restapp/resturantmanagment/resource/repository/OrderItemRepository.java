package com.example.finalproject_restapp.resturantmanagment.resource.repository;


import com.example.finalproject_restapp.resturantmanagment.dto.ItemDto;
import com.example.finalproject_restapp.resturantmanagment.model.OrderItem;

import java.util.List;

public interface OrderItemRepository {
    OrderItem add(OrderItem orderItem);

    List<ItemDto> getItemsByOrderId(int id);
}
