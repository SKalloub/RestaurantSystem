package com.example.finalproject_restapp.Adapters;

public class SItem {
    int image;
    String title;
    String desc;
    double price;
    int quantity;
    int id;
    public SItem(int image, String title, String desc, double price, int id) {
        this.image = image;
        this.title = title;
        this.desc = desc;
        this.price = price;
    }
    public SItem(int image, String title, String desc, double price, int id, int quantity) {
        this.image = image;
        this.title = title;
        this.desc = desc;
        this.price = price;
        this.quantity = quantity;
    }


}
