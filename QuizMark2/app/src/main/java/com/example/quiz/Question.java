package com.example.quiz;

import java.io.Serializable;

public class Question {
    private int question;
    private boolean answer;

    public Question(int question, boolean answer) {
        this.question = question;
        this.answer = answer;
    }

    public int getQuestion() {return question;}

    public boolean isAnswer() {return answer;}

}
