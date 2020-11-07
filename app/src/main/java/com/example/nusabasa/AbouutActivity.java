package com.example.nusabasa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AbouutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abouut);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Tentang");
        }
    }
}