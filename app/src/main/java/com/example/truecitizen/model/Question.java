package com.example.truecitizen.model;

public class Question {
    private final int answerResId;
    private final boolean answer;

    public Question(int answerResId, boolean answer) {
        this.answerResId = answerResId;
        this.answer = answer;
    }

    public int getAnswerResId() {
        return answerResId;
    }

    public boolean getAnswer() {
        return answer;
    }
}
