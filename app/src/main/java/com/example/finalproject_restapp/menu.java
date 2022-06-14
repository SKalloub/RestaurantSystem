package com.example.finalproject_restapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

import com.example.finalproject_restapp.Adapters.ItemsAdapter;
import com.example.finalproject_restapp.Adapters.SItem;
import com.example.finalproject_restapp.resturantmanagment.model.Item;

import java.util.ArrayList;
import java.util.List;

public class menu extends AppCompatActivity implements ItemsAdapter.ListItemClickListener  {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        recyclerView = findViewById(R.id.menuRec);

        ArrayList<SItem> sItems1 = new ArrayList<>();
//        sItems1.add(new SItem(6,"Pizza","Italian Pizza",4.49));
//        sItems1.add(new SItem(7,"Tiffin","Korean Rice",6.99));
//        sItems1.add(new SItem(8,"Inferno Fried","Hell Chicken",3.99));
//        sItems1.add(new SItem(9,"Biryani","Arabic Style",5.49));
//        sItems1.add(new SItem(10,"Fried Rice","Chinese Rice",4.99));
//        sItems1.add(new SItem(11,"Orgada Burger","Triple Meat",9.99));
//        sItems1.add(new SItem(6,"Pizza","Italian Pizza",4.49));
//        sItems1.add(new SItem(7,"Tiffin","Korean Rice",6.99));
//        sItems1.add(new SItem(8,"Inferno Fried","Hell Chicken",3.99));
//        sItems1.add(new SItem(9,"Biryani","Arabic Style",5.49));
//        sItems1.add(new SItem(10,"Fried Rice","Chinese Rice",4.99));
//        sItems1.add(new SItem(11,"Orgada Burger","Triple Meat",9.99));
        fillSItems(sItems1);
        adapter = new ItemsAdapter(sItems1,this,this);
        recyclerView.setAdapter(adapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);

    }

    private void fillSItems(ArrayList<SItem> sItems1) {
        RestaurantService restaurantService = RestaurantService.getInstance();
        List<Item> list = restaurantService.getAllItems();
        for (Item item: list)
        sItems1.add(new SItem(((int) (Math.random()*10))%5+4,item.getName(),"Cheesy Mozarella",Double.parseDouble(item.getPrice()+".99"),3));
    }


    @Override
    public void onItemListenClick(int clickedItemIndex) {

    }
}