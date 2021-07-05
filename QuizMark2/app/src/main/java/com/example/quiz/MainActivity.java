package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity {
    private Button yesBtn;
    private Button noBtn;
    private Button showAnswer;
    private TextView questionTextView;

    private Question[] questions = {
            new Question(R.string.question, true),
            new Question(R.string.question1, true),
            new Question(R.string.question2, false),
            new Question(R.string.question3, false),
            new Question(R.string.question4, true)
    };
    String[] quizAnswers = new String[5];
    int j = 0;
    private int questionIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null){
            questionIndex = savedInstanceState.getInt("question");
        }

        questionTextView = findViewById(R.id.questionTextView);
        questionTextView.setText(questions[questionIndex].getQuestion());
        yesBtn = findViewById(R.id.yesBtn);
        noBtn = findViewById(R.id.noBtn);
        showAnswer = findViewById(R.id.showAnswer);
        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(questions[questionIndex].isAnswer()){
                    Toast.makeText(MainActivity.this, R.string.correct, Toast.LENGTH_SHORT).show();
                    j++;
                    String answer = getString(questions[questionIndex].getQuestion()) + " Да.";
                    quizAnswers[questionIndex] = answer;
                }else{
                    Toast.makeText(MainActivity.this, R.string.incorrect, Toast.LENGTH_SHORT).show();
                    String answer = getString(questions[questionIndex].getQuestion()) + " Нет.";
                    quizAnswers[questionIndex] = answer;
                }

                /*
                * 1) Записываем строку "Вопрос - ваш ответ да/нет" в массив
                * 2) Складываем правильные ответы в переменню int
                * 3) Проверяем, что вопрос последний
                * 4) Если вопрос последний, то создаём интент
                * 5) Добавляем дополнение в Интент (массив с вопросамии ответами)
                * 6) Добавляем дополнение в Интент (int с числом правильных ответов)
                * 7) Запускаем активность
                * 8) На запущенной активности вывести строки из массива, тем самым отобразив вопросы и ответы пользователя
                *  */


                questionIndex = (questionIndex + 1);
                if(questionIndex < 5) {
                    questionTextView.setText(questions[questionIndex].getQuestion());
                }else{
                    Context context = MainActivity.this;
                    Class child = SecondActivity.class;
                    Intent intent = new Intent(context, child);
                    intent.putExtra("MyQuestions", quizAnswers);
                    intent.putExtra("MyCount", j);
                    startActivity(intent);
                }
            }
        });
        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!questions[questionIndex].isAnswer()){
                    Toast.makeText(MainActivity.this, R.string.correct, Toast.LENGTH_SHORT).show();
                    j++;
                    String answer = getString(questions[questionIndex].getQuestion()) + " Нет.";
                    quizAnswers[questionIndex] = answer;
                }else{
                    Toast.makeText(MainActivity.this, R.string.incorrect, Toast.LENGTH_SHORT).show();
                    String answer = getString(questions[questionIndex].getQuestion()) + " Да.";
                    quizAnswers[questionIndex] = answer;
                }

                questionIndex = (questionIndex + 1);
                if(questionIndex < 5) {
                    questionTextView.setText(questions[questionIndex].getQuestion());
                }else{
                    Context context = MainActivity.this;
                    Class child = SecondActivity.class;
                    Intent intent = new Intent(context, child);
                    intent.putExtra("MyQuestions", quizAnswers);
                    intent.putExtra("MyCount", j);
                    startActivity(intent);
                }
            }
        });

        showAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AnswerActivity.class);
                intent.putExtra("answer", questions[questionIndex].isAnswer());
                startActivity(intent);
            }
        });

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("question", questionIndex);
    }

}