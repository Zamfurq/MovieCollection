package com.example.nusabasa.jv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.nusabasa.R;

import java.util.ArrayList;

public class JavaneseActivity extends AppCompatActivity {
    private RecyclerView rvAssignment;
    private ArrayList<Javanese> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_javanese);

        rvAssignment = findViewById(R.id.rv_javanese);
        rvAssignment.setHasFixedSize(true);

        list.addAll(JavaneseData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList(){
        rvAssignment.setLayoutManager(new LinearLayoutManager(this));
        JavaneseAdapter listLanguageAdapter = new JavaneseAdapter(list);
        rvAssignment.setAdapter(listLanguageAdapter);
    }
}