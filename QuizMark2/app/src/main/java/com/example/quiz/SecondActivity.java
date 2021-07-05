package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView statisticsView;
    private TextView statisticsView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);

        statisticsView = findViewById(R.id.statisticsView);
        Intent intentQuizResults = getIntent();
        String questions[] = intentQuizResults.getStringArrayExtra("MyQuestions");
        statisticsView.append(questions[0]+"\n"+questions[1]+"\n"+questions[2]+"\n"+questions[3]+"\n"+questions[4]);

        statisticsView2 = findViewById(R.id.statisticsView2);
        Intent intentQuizCount = getIntent();
        int j = intentQuizCount.getIntExtra("MyCount", 0);
        String str = Integer.toString(j);
        statisticsView2.setText("Правильно: "+ str);

    }
}