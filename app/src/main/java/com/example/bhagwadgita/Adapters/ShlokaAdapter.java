package com.example.bhagwadgita.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bhagwadgita.Interfaces.ClickInterface;
import com.example.bhagwadgita.Models.Shloka;
import com.example.bhagwadgita.R;

import java.util.ArrayList;

public class ShlokaAdapter extends RecyclerView.Adapter<ShlokaAdapter.My1ViewHolder> {
    Context context;
    ArrayList<Shloka> shlokas;
    ClickInterface clickInterface;

    public ShlokaAdapter(Context context, ArrayList<Shloka> shlokas, ClickInterface clickInterface){
        this.context = context;
        this.shlokas = shlokas;
        this.clickInterface = clickInterface;
    }
    @NonNull
    @Override
    public My1ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.shloka_layout, parent, false);
        return new ShlokaAdapter.My1ViewHolder(view, clickInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull My1ViewHolder holder, int position) {
        holder.shloka_num.setText(String.format(" %s", shlokas.get(position).getShloka_num()));
    }

    @Override
    public int getItemCount() {
        return shlokas.size();
    }

    public static class My1ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ClickInterface clickInterface;
        TextView shloka_num;

        public My1ViewHolder(@NonNull View itemView, ClickInterface clickInterface) {
            super(itemView);

            shloka_num = itemView.findViewById(R.id.textView2);
            this.clickInterface = clickInterface;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            clickInterface.OnItemClick(getAdapterPosition());
        }
    }
}
