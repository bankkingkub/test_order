package com.example.work.test_order;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class user_register extends AppCompatActivity {
    EditText register_pw, register_user;
    TextView text_send_test;
    Intent testintent;
    final String url = "http://samples.openweathermap.org/data/2.5/weather?id=2172797&appid=b6907d289e10d714a6e88b30761fae22";
//    String text = "Tesst_intent";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);
//        testintent = new Intent(getApplicationContext(), chat_test.class);
        register_pw = (EditText) findViewById(R.id.register_pw);
        register_user = (EditText) findViewById(R.id.register_user);
        text_send_test = (TextView) findViewById(R.id.text_send_test);
    }

    public void onclick_regis(View view) {
        if (emptyValidate(register_pw, register_user)) {
            Toast.makeText(this, "empty", Toast.LENGTH_SHORT).show();
//            testintent.putExtra("", "");
//            setResult(RESULT_OK, testintent);

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

    //    public void register_insert() {
//        StringRequest request = new StringRequest(StringRequest.Method.GET, url, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                Log.d("a","onReasponse");
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.d("a","onError");
//
//            }
//        }){
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                Map<String, String> params = new HashMap<>();
//                params.put("password",register_pw.getText().toString());
//                Log.d("a","indata");
//                return params;
//
//            }
//        };
//        Volley.newRequestQueue(this).add(request);
//        Log.d("a","send context in");
//    }


        public void register_insert() {
            JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url,null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject main_object = response.getJSONObject("main");
                    JSONArray array =  response.getJSONArray("weather");
                    JSONObject object = array.getJSONObject(0);
                    String description = object.getString("description");
                    text_send_test.setText(description);


                } catch (JSONException b) {
                    b.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        );
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);
    }
}
