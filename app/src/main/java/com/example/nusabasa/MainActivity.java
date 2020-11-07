package com.example.nusabasa;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void MovePlay(View view) {
        Intent intent = new Intent(MainActivity.this, PlayActivity.class);
        startActivity(intent);
    }

    public void MoveAchievement(View view) {
        Intent intent = new Intent(MainActivity.this, AchievementActivity.class);
        startActivity(intent);
    }

    public void MoveSetting(View view) {
        Intent intent = new Intent(MainActivity.this, SettingActivity.class);
        startActivity(intent);
    }

    public void MoveAbout(View view) {
        Intent intent = new Intent(MainActivity.this, AbouutActivity.class);
        startActivity(intent);
    }
}