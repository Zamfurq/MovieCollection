package com.example.nusabasa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class PlayActivity extends AppCompatActivity {
    private RecyclerView rvLanguage;
    private ArrayList<Language> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        rvLanguage = findViewById(R.id.rv_bahasa);
        rvLanguage.setHasFixedSize(true);

        list.addAll(LanguageData.getListData());
        showRecyclerList();

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Pilih Bahasamu");
        }
    }

    private void showRecyclerList(){
        rvLanguage.setLayoutManager(new LinearLayoutManager(this));
        ListLanguageAdapter listLanguageAdapter = new ListLanguageAdapter(list);
        rvLanguage.setAdapter(listLanguageAdapter);
    }
}