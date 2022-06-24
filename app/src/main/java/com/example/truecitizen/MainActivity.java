package com.example.truecitizen;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.truecitizen.databinding.ActivityMainBinding;
import com.example.truecitizen.model.Question;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private int currentIndex = 0;

    private final Question[] questionBank = new Question[]{
            new Question(R.string.q_java, false),
            new Question(R.string.q_taj_mahal, true),
            new Question(R.string.q_android_studio, false),
            new Question(R.string.q_independence, true),
            new Question(R.string.q_india, true),
            new Question(R.string.q_python, true),
            new Question(R.string.q_relation, false),
            new Question(R.string.q_hello, true),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.questionTextView.setText(questionBank[currentIndex].getAnswerResId());

        binding.nextButton.setOnClickListener(view -> {
            currentIndex = (currentIndex + 1) % questionBank.length;
            updateQuestion();
        });

        binding.prevButton.setOnClickListener(view -> {
            if (currentIndex > 0) {
                currentIndex = (currentIndex - 1) % questionBank.length;
                updateQuestion();
            }
        });

        binding.trueButton.setOnClickListener(view -> checkAnswer(true));

        binding.falseButton.setOnClickListener(view -> checkAnswer(false));

    }

    private void checkAnswer(boolean userAnswer) {
        boolean answer = questionBank[currentIndex].getAnswer();
        int messageId;

        if (userAnswer == answer) {
            messageId = R.string.correct_answer;
        } else {
            messageId = R.string.wrong_answer;
        }

        Snackbar.make(binding.imageView, messageId, Snackbar.LENGTH_SHORT).show();
    }

    private void updateQuestion() {
        binding.questionTextView.setText(questionBank[currentIndex].getAnswerResId());
    }
}