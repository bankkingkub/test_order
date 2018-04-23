package com.example.work.test_order;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class home_user extends AppCompatActivity {

    public DatabaseReference myRef;
    private TextView mFirebaseTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_user);
        setContentView(R.layout.activity_home_user);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        myRef = database.getReference(); }

    public void AddClick(View view) {
        Map<String, Object> value = new HashMap<String, Object>();
        value.put("test","putdata");
        myRef.updateChildren(value);
    }

}
