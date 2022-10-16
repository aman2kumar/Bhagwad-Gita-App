package com.example.bhagwadgita;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bhagwadgita.Adapters.ChapterAdapter;
import com.example.bhagwadgita.Interfaces.ClickInterface;
import com.example.bhagwadgita.Models.Chapter;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity implements ClickInterface {

    ArrayList<Chapter> chapters = new ArrayList<>();
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setUpArray();
        ChapterAdapter chapterAdapter = new ChapterAdapter(this, chapters, this);

        recyclerView = findViewById(R.id.rv);

//        chapterAdapter = new ChapterAdapter(this, chapters);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(chapterAdapter);

    }
    private void setUpArray(){
        String[] chapter_nums = getResources().getStringArray(R.array.chapter_nums);
        String[] chapter_names = getResources().getStringArray(R.array.chapter_names);
        String[] chapter_titles = getResources().getStringArray(R.array.chapter_titles);

        for(int i = 0; i < chapter_names.length; i++){
            chapters.add(new Chapter(chapter_nums[i], chapter_names[i], chapter_titles[i]));
        }
    }

    @Override
    public void OnItemClick(int position) {
        Intent intent = new Intent(MainActivity2.this, SalkActivity.class);
        intent.putExtra("chapter_num", chapters.get(position).getChapter_num());
        startActivity(intent);
    }
}