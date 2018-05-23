package com.example.work.test_order;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
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

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;

public class user_register extends AppCompatActivity {
    EditText register_pw, register_user;
    TextView text_send_test;
    Intent testintent;
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

    public void onclick_regis(View view) throws IOException {
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
//
//        public void register_insert() {
//        StringRequest request = new StringRequest(StringRequest.Method.GET, url, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        }){
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                Map<String, String> params = new HashMap<>();
//                return params;
//
//            }
//        };
//        Volley.newRequestQueue(this).add(request);
//    }


//        public void register_insert() {
//            JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url,null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                try {
////                    JSONArray array =  response.getJSONArray("Jason_Object");
////                    JSONObject main_object = response.getJSONObject("name");
////                    JSONObject object = array.getJSONObject(0);
////                    String name = object.getString("name");
////                    text_send_test.setText(name);
//                    JSONArray array =  response.getJSONArray("Jason_Object");
//                    JSONObject main_object = response.getJSONObject("name");
//                    JSONObject object = array.getJSONObject(0);
//                    String name = object.getString("name");
//                    text_send_test.setText(name);
//
//
//                } catch (JSONException b) {
//                    b.printStackTrace();
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        }
//        );
//        RequestQueue queue = Volley.newRequestQueue(this);
//        queue.add(request);
//    }
    public void register_insert() throws IOException {
        OkHttpClient client = new OkHttpClient();
        final  String url = "http://10.0.2.2:8080/api/CheckLogin";
        okhttp3.Request request = new okhttp3.Request.Builder()
                .url(url)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                Log.d("asd","onFailure");
            }

            @Override
            public void onResponse(Call call, okhttp3.Response response) throws IOException {
                if (response.isSuccessful()){
                    String myResponse = response.body().string();
                    Log.d("asd","in response");
                    text_send_test.setText(myResponse);
                    user_register.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                        }
                    });

                }
            }
        });

        }


}
