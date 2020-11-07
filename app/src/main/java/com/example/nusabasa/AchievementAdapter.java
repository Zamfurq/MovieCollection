package com.example.nusabasa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class AchievementAdapter extends RecyclerView.Adapter<AchievementAdapter.ListViewHolder> {
    private ArrayList<Achievement> listAchievement;


    public AchievementAdapter(ArrayList<Achievement> list) {
        this.listAchievement = list;
    }

    @NonNull
    @Override
    public AchievementAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_achievement, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Achievement achievement = listAchievement.get(position);
        Glide.with(holder.itemView.getContext())
                .load(achievement.getIcon())
                .apply(new RequestOptions().override(100, 100))
                .into(holder.imgPhoto);
        holder.tvName.setText(achievement.getName());
        holder.tvDescription.setText(achievement.getDescription());
    }

    @Override
    public int getItemCount() {
        return listAchievement.size();
    }

    public static class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName;
        TextView tvDescription;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_achievement);
            tvName = itemView.findViewById(R.id.tv_achievement_name);
            tvDescription = itemView.findViewById(R.id.tv_achievement_description);
        }
    }
}
