package com.example.work.test_order;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class chat_test extends AppCompatActivity {
    EditText user;
    Intent testintent;
    final int REQUEST_CODE = 1234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_test);
        user = (EditText) findViewById(R.id.login_id);
        testintent = new Intent(getApplicationContext(), user_register.class);
    }

    public void onEditText() {

    }

    public void send(View view) {
    }

    public void onclick_login(View view) {
        Toast.makeText(this, "in", Toast.LENGTH_SHORT).show();

    }

    public void onclick_register(View view) {
        startActivityForResult(testintent, REQUEST_CODE);
        Toast.makeText(this, "register", Toast.LENGTH_SHORT).show();
    }

    protected void onActivityResult(int requestCode, int resultcode, Intent data) {
        super.onActivityResult(requestCode, resultcode, data);
        if (requestCode == REQUEST_CODE){
            String returnText = data.getStringExtra("value");
            Toast.makeText(this, returnText, Toast.LENGTH_SHORT).show();
        }else{
            user.setText("not_in");
            Toast.makeText(this, "outister", Toast.LENGTH_SHORT).show();
        }

    }
}
