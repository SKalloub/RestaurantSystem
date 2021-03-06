package com.example.finalproject_restapp.resturantmanagment.resource;

import com.example.finalproject_restapp.resturantmanagment.model.Item;
import com.example.finalproject_restapp.resturantmanagment.resource.repository.ItemRepository;

import java.util.ArrayList;
import java.util.List;

public class ItemRes implements ItemRepository {
    static ItemRes INSTANCE;

    public static ItemRes getInstance() {
        if (INSTANCE == null){
            synchronized (EmployeeRes.class){
                if (INSTANCE == null){
                    INSTANCE = new ItemRes();
                }
            }
        }
        return INSTANCE;
    }
    public static ArrayList<Item> items = new ArrayList<>() {{
        add(new Item(0, "Biryani", 10, "salad"));
        add(new Item(1, "Barbeque", 7, "salad"));
        add(new Item(2, "Inferno Chicken", 6, "main"));
        add(new Item(3, "Beef Burger", 12, "main"));
        add(new Item(4, "Saucy Fries", 11, "appetizers"));
        add(new Item(5, "Greece Salad", 5, "salad"));
        add(new Item(6, "Danish Salad", 6, "salad"));
        add(new Item(7, "Quru Pizza", 7, "main"));
        add(new Item(8, "Cheese Burger", 7, "main"));

    }};

    public Item findByName(String name) {
        for (Item item : items)
            if (item.getName().equals(name))
                return item;
        return null;
    }

    public Item findById(int id) {
        return items.get(id);
    }
    @Override
    public List<Item> getAllItems() {
        return items;
    }
}
