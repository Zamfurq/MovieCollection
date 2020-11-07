package com.example.nusabasa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        getSupportFragmentManager().beginTransaction().add(R.id.setting_holder, new MyPreferenceFragment()).commit();
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Setelan");
        }
    }
}