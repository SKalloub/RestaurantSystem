package com.example.finalproject_restapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashSet;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class OrderPage extends AppCompatActivity {
TextView quantity;
TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
       String value = intent.getStringExtra("key");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page);
        quantity = findViewById(R.id.quantity);
        title = findViewById(R.id.itemname);
       title.setText(value);
        int random = (int) Math.random()*10;
        random%=5;
        random+=4;
        ImageView imageView = findViewById(R.id.itemg);
        if (random==4)
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.friedrice));
        else if (random==5)
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.biryani));
        else if (random==6)
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.pizza));
        else if (random==7)
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.beefburger));
        else if (random==8)
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.tiffin));
        else if (random==9)
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.infernofried));
   }
public void onAddToCart(View view) {
    SweetAlertDialog sw;
    if (quantity.getText().toString().equals("0")) {
        sw = new SweetAlertDialog(OrderPage.this,SweetAlertDialog.ERROR_TYPE);
        sw.setContentText("Quantity is set to zero!");
        sw.show();
        return;
    }
    sw = new SweetAlertDialog(OrderPage.this,SweetAlertDialog.SUCCESS_TYPE);
    sw.setTitle("Added!");
    sw.setContentText("Your order has been added to your cart!");
    sw.setConfirmText("OK!");
    sw.show();
    SharedPreferences sharedPreferences = getSharedPreferences("Cart",MODE_PRIVATE);
    SharedPreferences.Editor editor = sharedPreferences.edit();
    System.out.println(sharedPreferences.getAll());
    TextView itemname = findViewById(R.id.itemname);
    HashSet<String> s = new HashSet<>();
    s.add(itemname.getText().toString());
    s.add(quantity.getText().toString());
    editor.putStringSet(itemname.getText().toString(),s);
    editor.commit();
    quantity.setText("0");



}
public void OnIncrement(View view) {
   String currentQuantity = quantity.getText().toString();
   int quantityV = Integer.parseInt(currentQuantity);
   if (quantityV<10) {
       quantityV++;
       quantity.setText(quantityV + "");
   }

}
public void OnDecrement(View view) {
    String currentQuantity = quantity.getText().toString();
    int quantityV = Integer.parseInt(currentQuantity);
    if (quantityV>0) {
        quantityV--;
        quantity.setText(quantityV + "");
    }
}
}