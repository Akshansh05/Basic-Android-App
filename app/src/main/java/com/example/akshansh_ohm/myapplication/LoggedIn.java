package com.example.akshansh_ohm.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LoggedIn extends AppCompatActivity {
private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);
     text=(TextView) findViewById(R.id.TextView_LoggedIn);
        Intent intent=getIntent();
        String username=intent.getStringExtra("NAME");//catch value of userID
        text.setText("Welcome, "+username);
    }
}
