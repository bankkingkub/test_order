package com.example.work.test_order;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class chat_test extends AppCompatActivity {
    String name;
    String user;
    public static final String URL = "http://localhost/FoodOrder_DB/connect.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_test);
    }

    public void onEditText() {

    }

    public void send(View view) {
    }

    public void onclick_login(View view) {
        Toast.makeText(this, "in", Toast.LENGTH_SHORT).show();

    }

    public void onclick_register(View view) {
        setContentView(R.layout.activity_user_register);

    }
}
