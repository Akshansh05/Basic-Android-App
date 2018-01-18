package com.example.akshansh_ohm.myapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Regpage extends AppCompatActivity {
    private String username, userId , password;
    private EditText editText_name;
    private EditText editText_ppassword;
    private EditText editText_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regpage);


        editText_name = (EditText) findViewById(R.id.editText_name);
        editText_ppassword = (EditText) findViewById(R.id.editText_ppassword);
        editText_id = (EditText) findViewById(R.id.editText_id);
        Button Button_reg = (Button) findViewById(R.id.button_create);

        Button_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }


        });
    }
    private void register()
    {
        username=editText_name.getText().toString();
        password=editText_ppassword.getText().toString();
        userId=editText_id.getText().toString();
        SQLiteDBHelper dbHelper = new SQLiteDBHelper(getApplicationContext());
        SQLiteDatabase db= dbHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(SQLiteDBHelper.COLUMN_ID,userId);
        values.put(SQLiteDBHelper.COLUMN_NAME,username);
        values.put(SQLiteDBHelper.COLUMN_PASS,password);
        db.insert(SQLiteDBHelper.TABLE_NAME,null,values);


        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
        finish();

    }
}