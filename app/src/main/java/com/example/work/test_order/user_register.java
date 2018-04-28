package com.example.work.test_order;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class user_register extends AppCompatActivity {
    EditText register_pw, register_user;
    Intent testintent;
    final String url = "http://localhost/FoodOrder_DB/rgister_in.php";
    String text = "Tesst_intent";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);
        testintent = new Intent(getApplicationContext(), chat_test.class);
        register_pw = (EditText) findViewById(R.id.register_pw);
        register_user = (EditText) findViewById(R.id.register_user);
    }

    public void onclick_regis(View view) {
        if (emptyValidate(register_pw, register_user)) {
            Toast.makeText(this, "empty", Toast.LENGTH_SHORT).show();
            testintent.putExtra("", "");
            setResult(RESULT_OK, testintent);

        } else {
            Toast.makeText(this, "Notempty", Toast.LENGTH_SHORT).show();
            register_insert();
        }
    }

    private boolean emptyValidate(EditText register_pw, EditText register_user) {
        String user = register_user.getText().toString();
        String password = register_pw.getText().toString();
        return (password.matches("") && user.matches(""));
    }

    public void register_insert() {
        StringRequest request = new StringRequest(StringRequest.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("id",register_user.getText().toString());
                params.put("password",register_pw.getText().toString());
                Log.d("a","Inhasmap");
                return params;

            }
        };
        Volley.newRequestQueue(this).add(request);
    }
}
