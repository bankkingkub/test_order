package com.example.work.test_order;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class chat_test extends AppCompatActivity {
    String name;
    String user;
    public static final String URL = "http://localhost/FoodOrder_DB/connect.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_test);
        login_id = (EditText) findViewById(R.id.login_id);
    }

    public void onEditText() {
        name = login_id.getText().toString();

    }

    public void send(View view) {
    }

    public void onclick_login(View view) {

    }
}
