package com.example.nusabasa.bl;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.nusabasa.R;
import com.example.nusabasa.ResultActivity;
import com.example.nusabasa.jv.QuestionData;

import java.util.ArrayList;

public class BaliQuiz2Activity extends AppCompatActivity implements View.OnClickListener {
    private int currentPosition = 1;
    private int selectedOption = 0;
    private int correctAnswers = 0;
    private ArrayList<BaliQuestion> questionList;
    private TextView tvQuestion;
    private TextView tvOptionOne;
    private TextView tvOptionTwo;
    private TextView tvOptionThree;
    private TextView tvProgress;
    private Button btnSubmit;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bali_quiz2);

        questionList = BaliQuestionData.getQuestions2();
        tvOptionOne = findViewById(R.id.tv_option_one_bali2);
        tvOptionTwo = findViewById(R.id.tv_option_two_bali2);
        tvOptionThree = findViewById(R.id.tv_option_three_bali2);
        btnSubmit = findViewById(R.id.btn_submit_bali2);
        tvProgress = findViewById(R.id.tv_progress_bali2);
        tvQuestion = findViewById(R.id.tv_question_bali2);
        progressBar = findViewById(R.id.progressbar_bali2);
        tvOptionOne.setOnClickListener(this);
        tvOptionTwo.setOnClickListener(this);
        tvOptionThree.setOnClickListener(this);
        btnSubmit.setOnClickListener(this);
        setQuestion();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tv_option_one_bali2){
            selectedOptionView(tvOptionOne,1);
        }
        else if (v.getId() == R.id.tv_option_two_bali2) {
            selectedOptionView(tvOptionTwo,2);
        }
        else if (v.getId() == R.id.tv_option_three_bali2) {
            selectedOptionView(tvOptionThree,3);
        }
        else if (v.getId() == R.id.btn_submit_bali2){
            if (selectedOption == 0){
                currentPosition++;
                if (currentPosition <= questionList.size()) {
                    setQuestion();
                } else {
                    Intent intent = new Intent(BaliQuiz2Activity.this, ResultActivity.class);
                    intent.putExtra(QuestionData.CORRECT_ANSWERS, correctAnswers);
                    intent.putExtra(QuestionData.TOTAL_QUESTION, questionList.size());
                    startActivity(intent);
                    finish();
                }
            } else {
                BaliQuestion question = questionList.get(currentPosition - 1);
                if (question.correctAnswer != selectedOption) {
                    answersView(selectedOption,R.drawable.wrong_option);
                } else {
                    correctAnswers++;
                }
                answersView(question.correctAnswer, R.drawable.correct_option);
                if (currentPosition == questionList.size()){
                    btnSubmit.setText("SELESAI");
                } else {
                    btnSubmit.setText("KE PERTANYAAN SELANJUTNYA");
                }
                selectedOption = 0;
            }
        }
    }

    private void setQuestion() {
        BaliQuestion question = questionList.get(currentPosition - 1);
        defaultOptionView();
        if (currentPosition == questionList.size()) {
            btnSubmit.setText("SELESAI");
        } else {
            btnSubmit.setText("JAWAB");
        }
        progressBar.setProgress(currentPosition);
        tvProgress.setText(currentPosition + "/" + progressBar.getMax());
        tvQuestion.setText(question.question);
        tvOptionOne.setText(question.optionOne);
        tvOptionTwo.setText(question.optionTwo);
        tvOptionThree.setText(question.optionThree);
    }

    private void selectedOptionView(TextView tv, int selecteOptionNum) {
        defaultOptionView();
        selectedOption = selecteOptionNum;
        tv.setTextColor(Color.parseColor("#363A43"));
        tv.setTypeface(tv.getTypeface(), Typeface.BOLD);
        tv.setBackground(ContextCompat.getDrawable(BaliQuiz2Activity.this,R.drawable.selected_option));
    }

    private void defaultOptionView() {
        ArrayList<TextView> options = new ArrayList<>();
        options.add(0,tvOptionOne);
        options.add(1,tvOptionTwo);
        options.add(2,tvOptionThree);


        for (int i = 0;i < options.size();i++){
            TextView option = options.get(i);
            option.setTextColor(Color.parseColor("#363A43"));
            option.setTypeface(Typeface.DEFAULT);
            option.setBackground(ContextCompat.getDrawable(BaliQuiz2Activity.this,R.drawable.default_option_border_bg));
        }
    }

    private void answersView(int answers, int drawableView) {
        if (answers == 1) {
            tvOptionOne.setBackground(ContextCompat.getDrawable(BaliQuiz2Activity.this,drawableView));
        } else if (answers == 2) {
            tvOptionTwo.setBackground(ContextCompat.getDrawable(BaliQuiz2Activity.this,drawableView));
        } else if (answers == 3) {
            tvOptionThree.setBackground(ContextCompat.getDrawable(BaliQuiz2Activity.this,drawableView));
        }
    }

}