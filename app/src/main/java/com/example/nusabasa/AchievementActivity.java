package com.example.nusabasa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class AchievementActivity extends AppCompatActivity {
    private RecyclerView rvAchievement;
    private ArrayList<Achievement> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievement);

        rvAchievement = findViewById(R.id.rv_achievement);
        rvAchievement.setHasFixedSize(true);

        list.addAll(AchievementData.getListData());
        showRecyclerList();

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Penghargaanmu");
        }
    }

    private void showRecyclerList(){
        rvAchievement.setLayoutManager(new LinearLayoutManager(this));
        AchievementAdapter achievementAdapter = new AchievementAdapter(list);
        rvAchievement.setAdapter(achievementAdapter);
    }
}