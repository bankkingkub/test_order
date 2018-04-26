package com.example.work.test_order;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class user_register extends AppCompatActivity {
    EditText register_pw, register_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);

        register_pw = (EditText) findViewById(R.id.register_pw);
        register_user = (EditText) findViewById(R.id.register_user);
    }

    public void onclick_regis(View view) {
        if (emptyValidate(register_pw, register_user)) {
            Toast.makeText(this, "empty", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, "Notempty", Toast.LENGTH_SHORT).show();

        }
    }

    private boolean emptyValidate(EditText register_pw, EditText register_user) {
        String user = register_user.getText().toString();
        String password = register_pw.getText().toString();
        return (password.matches("") && user.matches(""));
    }
}
