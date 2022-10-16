package com.example.bhagwadgita;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private TextView tv1, tv2, tv3, tv4, tv5;
    private static final String url_start = "https://bhagavadgitaapi.in/slok/";  //https://bhagavadgitaapi.in/slok/12/10/;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.textView2);
        tv2 = findViewById(R.id.textView4);
        tv3 = findViewById(R.id.textView6);
        tv4 = findViewById(R.id.textView8);
        tv5 = findViewById(R.id.textView10);

        String chapter_num = getIntent().getStringExtra("chapter_num");
        String hymn_num = getIntent().getStringExtra("shloka_num");

        String url = url_start + chapter_num + "/" + hymn_num + "/";

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(MainActivity.this, "God Bless You", Toast.LENGTH_SHORT).show();
                try {
                    tv1.setText(response.getString("slok"));
                    tv2.setText(response.getString("transliteration"));
                    tv3.setText(response.getJSONObject("tej").getString("ht"));
                    tv4.setText(response.getJSONObject("siva").getString("et"));
                    tv5.setText(response.getJSONObject("chinmay").getString("hc"));
                    Log.d("gii", "onResponse: success");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("gii", "onResponse: failed");
                Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
                // TODO: Handle error

            }
        });

        requestQueue.add(jsonObjectRequest);
    }
}