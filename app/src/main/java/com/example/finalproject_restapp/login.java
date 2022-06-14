package com.example.finalproject_restapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class login extends AppCompatActivity {
EditText email, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email=  findViewById(R.id.editTextTextEmailAddress);
        password = findViewById(R.id.editTextPassword);
    }

    public void onClickOnCreateAccount(View view) {

    }
    public void onLoginClick(View view) {
        String emailAddress = email.getText().toString();
        String Pass = password.getText().toString();
        RequestQueue queue = Volley.newRequestQueue(login.this);
        String url = "localhost/api/UserLogin.php?username="+emailAddress+"password="+Pass;
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url,
                null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {

                    try {
                        JSONObject obj = response.getJSONObject(i);
                        System.out.println(obj.toString());


                    }
                    catch(JSONException exception){
                        Toast.makeText(login.this, exception.toString(),
                                Toast.LENGTH_SHORT).show();
                    }

                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(login.this, error.toString(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        queue.add(request);

    }
}