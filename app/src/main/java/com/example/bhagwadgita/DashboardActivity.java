package com.example.bhagwadgita;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class DashboardActivity extends AppCompatActivity {

    CardView cardView1, cardView2, cardView3, cardView4, cardView5, cardView6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        cardView1 = findViewById(R.id.cardView1);

        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });

    }
}