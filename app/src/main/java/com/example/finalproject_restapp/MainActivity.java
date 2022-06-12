package com.example.finalproject_restapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.finalproject_restapp.Adapters.ItemsAdapter;
import com.example.finalproject_restapp.Adapters.SItem;
import com.example.finalproject_restapp.resturantmanagment.model.Item;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemsAdapter.ListItemClickListener {
RecyclerView recyclerView;
RecyclerView.Adapter adapter;
RecyclerView recyclerView2;
RecyclerView.Adapter adapter2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.my_recycler);
        recyclerView2 = findViewById(R.id.my_recycler2);

        ArrayList<SItem> sItems = new ArrayList<>();
        fill(sItems,1);
//        sItems.add(new SItem(sItems.size(),"Cheese Burger","Extra Cheese",6.99));
//        sItems.add(new SItem(sItems.size(),"Inferno Burger","Hell sauce",5.99));
//        sItems.add(new SItem(sItems.size(),"Grill Burger","White Sauce",6.99));
//        sItems.add(new SItem(sItems.size(),"Orgada Burger","Triple Meat",9.99));

        ArrayList<SItem> sItems1 = new ArrayList<>();
        fill(sItems1,-1);
//        sItems1.add(new SItem(6,"Pizza","Italian Pizza",4.49));
//        sItems1.add(new SItem(7,"Tiffin","Korean Rice",6.99));
//        sItems1.add(new SItem(8,"Inferno Fried","Hell Chicken",3.99));
//        sItems1.add(new SItem(9,"Biryani","Arabic Style",5.49));
//        sItems1.add(new SItem(10,"Fried Rice","Chinese Rice",4.99));
//        sItems1.add(new SItem(6,"Pizza","Italian Pizza",4.49));
//        sItems1.add(new SItem(7,"Tiffin","Korean Rice",6.99));
//        sItems1.add(new SItem(8,"Inferno Fried","Hell Chicken",3.99));
//        sItems1.add(new SItem(9,"Biryani","Arabic Style",5.49));
//        sItems1.add(new SItem(10,"Fried Rice","Chinese Rice",4.99));

        adapter = new ItemsAdapter(sItems,this,this);
        adapter2 = new ItemsAdapter(sItems1,this,this);
        recyclerView.setAdapter(adapter);
        recyclerView2.setAdapter(adapter2);
        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView2.setLayoutManager(layoutManager);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private void fill(ArrayList<SItem> sItems, int i) {
        RestaurantService service = RestaurantService.getInstance();
        List<Item> list = service.getAllItems();
        if (i==1)
        for (int j = 0; j < list.size(); j++) {
            Item item = list.get(j);
            sItems.add(new SItem(((int) (Math.random()*10))%5+4,item.getName(),"Cheesy Mozarella",Double.parseDouble(item.getPrice()+".99"),3));
        }
        else {
            for (int j = list.size()-1; j >=0 ; j--) {
                Item item = list.get(j);
                sItems.add(new SItem(((int) (Math.random()*10))%5+4,item.getName(),"Cheesy Mozarella",Double.parseDouble(item.getPrice()+".99"),3));

            }
        }
    }

    @Override
    public void onItemListenClick(int clickedItemIndex) {
        Toast.makeText(this,"Hi",Toast.LENGTH_SHORT);
    }
}