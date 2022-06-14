package com.example.finalproject_restapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.finalproject_restapp.Adapters.ItemsAdapter;
import com.example.finalproject_restapp.Adapters.SItem;
import com.example.finalproject_restapp.Adapters.lItemsAdapter;

import java.util.ArrayList;

public class cart extends AppCompatActivity implements lItemsAdapter.ListItemClickListener{
RecyclerView recyclerView;
RecyclerView.Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        recyclerView = findViewById(R.id.menuRec2);
        ArrayList<SItem> sItems = new ArrayList<>();
        sItems.add(new SItem(6,"Cheese Burger","Cheesy Mozarella",7.99,3,2));
        sItems.add(new SItem(6,"Cheese Burger","Cheesy Mozarella",7.99,3,2));
        sItems.add(new SItem(6,"Cheese Burger","Cheesy Mozarella",7.99,3,2));
        sItems.add(new SItem(6,"Cheese Burger","Cheesy Mozarella",7.99,3,2));
        sItems.add(new SItem(6,"Cheese Burger","Cheesy Mozarella",7.99,3,2));
        sItems.add(new SItem(6,"Cheese Burger","Cheesy Mozarella",7.99,3,2));
        sItems.add(new SItem(6,"Cheese Burger","Cheesy Mozarella",7.99,3,2));
        sItems.add(new SItem(6,"Cheese Burger","Cheesy Mozarella",7.99,3,2));

        adapter = new lItemsAdapter(sItems,this,this);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

    }

    @Override
    public void onItemListenClick(int clickedItemIndex) {

    }
}