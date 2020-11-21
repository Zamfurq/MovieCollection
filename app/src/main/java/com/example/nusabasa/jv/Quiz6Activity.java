package com.example.nusabasa.jv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.nusabasa.R;
import com.example.nusabasa.ResultActivity;

import java.util.ArrayList;

public class Quiz6Activity extends AppCompatActivity implements View.OnClickListener {
    private int currentPosition = 1;
    private int correctAnswers = 0;
    private ArrayList<FillTextQuestion> questionList = null;
    private TextView tvQuestion;
    private EditText editText;
    private TextView tvProgress;
    private Button btnSubmit;
    private ProgressBar progressBar;
    public static final String EXTRA_QUESTION = "extra_question";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz6);

        questionList = getIntent().getParcelableArrayListExtra(EXTRA_QUESTION);
        btnSubmit = findViewById(R.id.btn_submit6);
        editText = findViewById(R.id.edit_text);
        tvProgress = findViewById(R.id.tv_progress6);
        tvQuestion = findViewById(R.id.tv_question6);
        progressBar = findViewById(R.id.progressbar6);
        btnSubmit.setOnClickListener(this);
        setQuestion();
    }

    @Override
    public void onClick(View v) {
        Editable answer = editText.getText();
        if (v.getId() == R.id.btn_submit6) {
            if (answer.toString().isEmpty()){
                currentPosition++;
                if (currentPosition <= questionList.size()) {
                    setQuestion();
                } else {
                    Intent intent = new Intent(Quiz6Activity.this, ResultActivity.class);
                    intent.putExtra(QuestionData.CORRECT_ANSWERS, correctAnswers);
                    intent.putExtra(QuestionData.TOTAL_QUESTION, questionList.size());
                    startActivity(intent);
                    finish();
                }
            } else {
                FillTextQuestion question = questionList.get(currentPosition - 1);
                if (!question.answer.equalsIgnoreCase(answer.toString())) {
                    answersView(R.drawable.wrong_option);
                } else {
                    correctAnswers++;
                    answersView(R.drawable.correct_option);
                    if (currentPosition == questionList.size()){
                        btnSubmit.setText("SELESAI");
                    } else {
                        btnSubmit.setText("KE PERTANYAAN SELANJUTNYA");
                    }
                }
                answer.clear();
            }
        }
    }

    private void setQuestion() {
        FillTextQuestion question = questionList.get(currentPosition - 1);
        if (currentPosition == questionList.size()) {
            btnSubmit.setText("SELESAI");
        } else {
            btnSubmit.setText("JAWAB");
        }
        progressBar.setProgress(currentPosition);
        tvProgress.setText(currentPosition + "/" + progressBar.getMax());
        tvQuestion.setText(question.question);
    }

    private void answersView( int drawableView) {
        editText.setBackground(ContextCompat.getDrawable(Quiz6Activity.this,drawableView));
    }
}