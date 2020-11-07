package com.example.nusabasa.bl;

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
import com.example.nusabasa.jv.QuestionData;

import java.util.ArrayList;

public class BaliQuiz7Activity extends AppCompatActivity implements View.OnClickListener {
    private int currentPosition = 1;
    private int correctAnswers = 0;
    private ArrayList<BaliFillTextQuestion> questionList;
    private TextView tvQuestion;
    private EditText editText;
    private TextView tvProgress;
    private Button btnSubmit;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bali_quiz7);

        questionList = BaliFillTextQuestionData.getQuestions();
        btnSubmit = findViewById(R.id.btn_submit_bali6);
        editText = findViewById(R.id.edit_text_bali);
        tvProgress = findViewById(R.id.tv_progress_bali6);
        tvQuestion = findViewById(R.id.tv_question_bali6);
        progressBar = findViewById(R.id.progressbar_bali6);
        btnSubmit.setOnClickListener(this);
        setQuestion();
    }

    @Override
    public void onClick(View v) {
        Editable answer = editText.getText();
        if (v.getId() == R.id.btn_submit_bali6) {
            if (answer.toString().isEmpty()){
                currentPosition++;
                if (currentPosition <= questionList.size()) {
                    setQuestion();
                } else {
                    Intent intent = new Intent(BaliQuiz7Activity.this, ResultActivity.class);
                    intent.putExtra(QuestionData.CORRECT_ANSWERS, correctAnswers);
                    intent.putExtra(QuestionData.TOTAL_QUESTION, questionList.size());
                    startActivity(intent);
                    finish();
                }
            } else {
                BaliFillTextQuestion question = questionList.get(currentPosition - 1);
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
        BaliFillTextQuestion question = questionList.get(currentPosition - 1);
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
        editText.setBackground(ContextCompat.getDrawable(BaliQuiz7Activity.this,drawableView));
    }

}