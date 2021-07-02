package com.example.secondapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView; //создаем элемент
    ArrayList<User> users = new ArrayList<>(); //создаем список пользователей
    UserAdapter userAdapter; //создаем элемент
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview); //ищем и включаем в переменную виджет
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));  //задаем размещение элементов линейно
        for (int i = 0; i < 100; i++){ //цикл создает 100 пользователей
            User user = new User();
            user.setUserName("Пользователь №"+i); //каждому созданному пользователю задается имя по его номеру
            user.setUserLastName("Фамилия №" +i); //каждому созданному пользователю задается фамилия по его номеру
            users.add(user); //добавляем 100 созданных пользователей в список
        }
        userAdapter = new UserAdapter(users); //передаем коллекцию пользователей адаптеру
        recyclerView.setAdapter(userAdapter); //подключаем адаптер к ресайклеру
    }
    private class UserHolder extends RecyclerView.ViewHolder{ // создаем объет для создания элементов списка
        TextView itemTextView;
        public UserHolder(LayoutInflater inflater, ViewGroup viewGroup) {
            super(inflater.inflate(R.layout.single_item, viewGroup, false));   //раздуваем активность
            itemTextView = itemView.findViewById(R.id.itemTextView); // ищем текст
        }

        public void bind(String userString){
            itemTextView.setText(userString); //выводим список на экран
        }
    }
    private class UserAdapter extends RecyclerView.Adapter<UserHolder>{
        ArrayList<User> users;
        public UserAdapter(ArrayList<User> users) {  //принимаем и сохраняем коллекцию пользователей
            this.users = users;
        }
        @Override
        public UserHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this); // создает макет
            return new UserHolder(inflater, viewGroup);  // создаем макет
        }

        @Override
        public void onBindViewHolder(UserHolder userHolder,int position) {    //связываем элементы
            User user = users.get(position);   //вытаскиваем нужного пользователя
            String userString = user.getUserName()+"\n"+user.getUserLastNameName();   //связываем имя и фамилию пользователя
            userHolder.bind(userString);  // связываем и создаем одного пользователя
        }


        @Override
        public int getItemCount() {   //узнаем количество элементов
            return users.size();  //количество элементов = количеству пользователей (100)
        }
    }
}

