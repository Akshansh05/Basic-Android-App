package com.example.akshansh_ohm.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.akshansh_ohm.myapplication.R.id.editText_id;
import static com.example.akshansh_ohm.myapplication.R.id.editText_password;
import static com.example.akshansh_ohm.myapplication.R.id.editText_useridd;

public class MainActivity extends AppCompatActivity {
    private String userid , password;
    private EditText editText_username;
    private EditText editText_password;
    private EditText editText_useridd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // editText_username = (EditText) findViewById(R.id.editText_username);
        editText_password  = (EditText) findViewById(R.id.editText_password);
        editText_useridd = (EditText) findViewById(R.id.editText_useridd);
        Button login = (Button) findViewById(R.id.Button_Login);
        Button Register = (Button) findViewById(R.id.Button_Register);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();

            }

            private void login() {
                userid=editText_useridd.getText().toString();
                password=editText_password.getText().toString();
                SQLiteDBHelper dbHelper = new SQLiteDBHelper(getApplicationContext());
                SQLiteDatabase db = dbHelper.getReadableDatabase();

                 Cursor cursor = db.rawQuery("SELECT * FROM " + SQLiteDBHelper.TABLE_NAME + " WHERE " + SQLiteDBHelper.COLUMN_ID + "=? AND" +
                        " " + SQLiteDBHelper.COLUMN_PASS + "=?", new String[]{userid, password});
                if (cursor != null)
                    if (cursor.getCount() > 0) {
                        Toast.makeText(getApplicationContext(), "Login Successful!", Toast.LENGTH_SHORT).show();
                        cursor.moveToFirst();
                        String name = cursor.getString(cursor.getColumnIndex(SQLiteDBHelper.COLUMN_NAME));
                        Intent intent = new Intent(getApplicationContext(), LoggedIn.class);
                        intent.putExtra("NAME", name);
                        startActivity(intent);
                        cursor.close();
                        finish();
                    } else {

                        Toast.makeText(getApplicationContext(), "Login Failed!", Toast.LENGTH_SHORT).show();
                        cursor.close();
                    }
            }
        });
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Regpage.class);
                startActivity(intent);
            }
        });
    }

    }
