package com.example.finalproject_restapp.resturantmanagment.resource.repository;


import com.example.finalproject_restapp.resturantmanagment.model.Item;

import java.util.List;

public interface ItemRepository {
   Item findByName(String name);
   List<Item> getAllItems();

   Item findById(int id);
}
