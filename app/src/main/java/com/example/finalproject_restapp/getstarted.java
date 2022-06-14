package com.example.finalproject_restapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class getstarted extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getstarted);
    }

    public void onClickGetStarted(View view){
        Intent intent = new Intent(this, login.class);
        this.startActivity(intent);
    }
}