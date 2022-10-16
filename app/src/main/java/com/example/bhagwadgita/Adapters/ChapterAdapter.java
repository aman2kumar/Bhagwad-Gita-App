package com.example.bhagwadgita.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bhagwadgita.Interfaces.ClickInterface;
import com.example.bhagwadgita.Models.Chapter;
import com.example.bhagwadgita.R;

import java.util.ArrayList;

public class ChapterAdapter extends RecyclerView.Adapter<ChapterAdapter.MyViewHolder> {

    ClickInterface clickInterface;
    Context context;
    ArrayList<Chapter> chapters;

    public ChapterAdapter(Context context, ArrayList<Chapter> chapters, ClickInterface clickInterface){
        this.context = context;
        this.chapters = chapters;
        this.clickInterface = clickInterface;
    }
    @NonNull
    @Override
    public ChapterAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.chapter_layout, parent, false);
        return new ChapterAdapter.MyViewHolder(view, clickInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull ChapterAdapter.MyViewHolder holder, int position) {
        holder.chapter_num.setText(chapters.get(position).getChapter_num());
        holder.chapter_name.setText(chapters.get(position).getChapter_title());
        holder.chapter_title.setText(chapters.get(position).getChapter_name());

    }

    @Override
    public int getItemCount() {
        return chapters.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ClickInterface clickInterface;
        TextView chapter_num, chapter_name, chapter_title;

        public MyViewHolder(@NonNull View itemView, ClickInterface clickInterface) {
            super(itemView);

            chapter_num = itemView.findViewById(R.id.textView1);
            chapter_name = itemView.findViewById(R.id.textView2);
            chapter_title = itemView.findViewById(R.id.textView3);
            this.clickInterface = clickInterface;

            itemView.setOnClickListener(this);

//            itemView.setOnClickListener(view -> {
//                if(chapterInterface != null){
//                    int pos = getAdapterPosition();
//                    if(pos != RecyclerView.NO_POSITION){
//                        chapterInterface.OnItemClick(pos);
//                        Log.e("Check", pos + "");
//                    }
//                }
//            });

        }

        @Override
        public void onClick(View view) {
            clickInterface.OnItemClick(getAdapterPosition());
        }
    }

}
