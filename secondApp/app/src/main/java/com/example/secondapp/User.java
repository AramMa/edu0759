package com.example.secondapp;

import java.util.UUID;
import java.util.jar.Attributes;

public class User { //задаем пользователя
    private String userName; //задаем  имя пользователя
    private String userLastName; //задаем фамилию пользователя
    private UUID uuid; //задаем идентификатор пользователя
    private String phone; //задаем телефон пользователя

    public User(){
        this.uuid = UUID.randomUUID(); //при создании пользователя он получит уникальный случайный идентификатор
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName (String userName) {
        this.userName = userName;
    }

    public String getUserLastNameName() {
        return userLastName;
    }

    public void setUserLastName (String userLastName) {
        this.userLastName = userLastName;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone (String userPhone) {
        this.phone = phone;
    }
    public UUID getUuid(){
        return uuid;
    }
}
