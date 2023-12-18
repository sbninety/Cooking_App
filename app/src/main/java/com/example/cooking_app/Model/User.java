package com.example.cooking_app.Model;

import android.graphics.Bitmap;

import java.io.Serializable;

public class User {
    private int id;
    private String email;
    private String password;
    private String name;
    public Bitmap image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public User(int id, String email, String password, String name, Bitmap image) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.image = image;
    }

    public User() {
    }
}
