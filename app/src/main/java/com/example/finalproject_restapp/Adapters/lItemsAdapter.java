package com.example.finalproject_restapp.Adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject_restapp.OrderPage;
import com.example.finalproject_restapp.R;

import java.util.ArrayList;

public class lItemsAdapter extends RecyclerView.Adapter<lItemsAdapter.mitem>{

    ArrayList<SItem> sItems;
    final private lItemsAdapter.ListItemClickListener listItemClickListener;
    AppCompatActivity activity;
    public lItemsAdapter(ArrayList<SItem> sItems, lItemsAdapter.ListItemClickListener listItemClickListener, AppCompatActivity activity) {
        this.listItemClickListener = listItemClickListener;
        this.sItems = sItems;
        this.activity = activity;
    }

    @NonNull
    @Override
    public lItemsAdapter.mitem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item2, parent,false);
        return new lItemsAdapter.mitem(view);
    }

    @Override
    public void onBindViewHolder(@NonNull lItemsAdapter.mitem holder, int position) {
        SItem item = sItems.get(position);
        if (item.image==6)
            holder.imageView.setImageDrawable(activity.getResources().getDrawable(R.drawable.pizza));
        else if (item.image==7)
            holder.imageView.setImageDrawable(activity.getResources().getDrawable(R.drawable.tiffin));
        else if (item.image==8)
            holder.imageView.setImageDrawable(activity.getResources().getDrawable(R.drawable.infernofried));
        else if (item.image==9)
            holder.imageView.setImageDrawable(activity.getResources().getDrawable(R.drawable.biryani));

        else if (item.image==10)
            holder.imageView.setImageDrawable(activity.getResources().getDrawable(R.drawable.friedrice));

        holder.itemTitle.setText(item.title);
        holder.itemPrice.setText(item.price+"");
        holder.dollar.setText("$");
        holder.itemDesc.setText(item.desc);
    }

    @Override
    public int getItemCount() {
        return sItems.size();
    }
    public interface ListItemClickListener {
        void onItemListenClick(int clickedItemIndex);
    }

    public class mitem extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imageView;
        TextView itemTitle;
        TextView itemDesc;
        TextView itemPrice;
        TextView dollar;

        ConstraintLayout constraintLayout;
        public mitem(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            imageView = itemView.findViewById(R.id.itemimage);
            itemTitle = itemView.findViewById(R.id.itemTitle);
            itemDesc = itemView.findViewById(R.id.itemDesc);
            itemPrice = itemView.findViewById(R.id.price);
            dollar = itemView.findViewById(R.id.dollar);
        }

        @Override
        public void onClick(View view) {
            Intent myIntent = new Intent(activity, OrderPage.class);
            myIntent.putExtra("key",itemTitle.getText().toString()); //Optional parameters
            activity.startActivity(myIntent);
        }
    }
}