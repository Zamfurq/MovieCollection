package com.example.nusabasa.bl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.nusabasa.R;

import java.util.ArrayList;

public class BalineseActivity extends AppCompatActivity {
    private RecyclerView rvAssignment;
    private ArrayList<Balinese> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balinese);

        rvAssignment = findViewById(R.id.rv_balinese);
        rvAssignment.setHasFixedSize(true);

        list.addAll(BalineseData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList(){
        rvAssignment.setLayoutManager(new LinearLayoutManager(this));
        BalineseAdapter listLanguageAdapter = new BalineseAdapter(list);
        rvAssignment.setAdapter(listLanguageAdapter);
    }
}