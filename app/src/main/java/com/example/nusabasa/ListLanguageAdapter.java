package com.example.nusabasa;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.nusabasa.bl.BalineseActivity;
import com.example.nusabasa.jv.JavaneseActivity;

import java.util.ArrayList;

public class ListLanguageAdapter extends RecyclerView.Adapter<ListLanguageAdapter.ListViewHolder> {
    private ArrayList<Language> listLanguage;

    public ListLanguageAdapter(ArrayList<Language> list) {
        this.listLanguage = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bahasa, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        final Language language = listLanguage.get(position);
        Glide.with(holder.itemView.getContext())
                .load(language.getImage())
                .apply(new RequestOptions().override(105, 55))
                .into(holder.imgPhoto);
        holder.tvName.setText(language.getLanguage());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                switch (language.getLanguage()){
                    case "Jawa":{
                        Intent intent = new Intent(context, JavaneseActivity.class);
                        context.startActivity(intent);
                        break;
                    }
                    case "Bali": {
                        Intent intent = new Intent(context, BalineseActivity.class);
                        context.startActivity(intent);
                        break;
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listLanguage.size();
    }

    public static class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_bahasa);
            tvName = itemView.findViewById(R.id.name_bahasa);
        }
    }
}
