package com.example.nusabasa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.nusabasa.jv.QuestionData;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        int totalQuestions = getIntent().getIntExtra(QuestionData.TOTAL_QUESTION, 0);
        int correctAnswers = getIntent().getIntExtra(QuestionData.CORRECT_ANSWERS, 0);
        TextView tvScore = findViewById(R.id.tv_score);
        tvScore.setText("Skor Anda "+ correctAnswers + " dari "+ totalQuestions);
        Button button = findViewById(R.id.btn_finish);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_finish) {
            Intent intent = new Intent(ResultActivity.this,MainActivity.class);
            startActivity(intent);
        }
    }
}