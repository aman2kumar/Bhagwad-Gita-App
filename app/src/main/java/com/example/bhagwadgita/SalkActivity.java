package com.example.bhagwadgita;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bhagwadgita.Adapters.ShlokaAdapter;
import com.example.bhagwadgita.Interfaces.ClickInterface;
import com.example.bhagwadgita.Models.Shloka;

import java.util.ArrayList;

public class SalkActivity extends AppCompatActivity implements ClickInterface {

    ArrayList<Shloka> shlokas = new ArrayList<>();
    RecyclerView recyclerView;
    int[] total_slokas = new int[]{47, 72, 43, 42, 29, 47, 30, 28, 34, 42, 55, 20, 35, 27, 20, 24, 28, 78};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shloka);
        String chapter_num = getIntent().getStringExtra("chapter_num");
        String intValue = chapter_num.replaceAll("[^0-9]", "");
        int val = Integer.parseInt(intValue);
        setUpArray(val);
        ShlokaAdapter shlokaAdapter = new ShlokaAdapter(this, shlokas, this);

        recyclerView = findViewById(R.id.recyclerView);

//        chapterAdapter = new ChapterAdapter(this, chapters);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(shlokaAdapter);

    }
    private void setUpArray(int val){

        for(int i = 0; i < total_slokas[val - 1]; i++){
            shlokas.add(new Shloka(String.valueOf(i+1), String.valueOf(val)));
        }
    }

    @Override
    public void OnItemClick(int position) {
        Intent intent = new Intent(SalkActivity.this, MainActivity.class);
        intent.putExtra("shloka_num", shlokas.get(position).getShloka_num());
        intent.putExtra("chapter_num", shlokas.get(position).getChapter_num());
        startActivity(intent);
    }
}