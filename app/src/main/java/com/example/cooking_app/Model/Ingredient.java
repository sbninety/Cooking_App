package com.example.cooking_app.Model;

public class Ingredient {
    private int id;
    private String Name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Ingredient() {
    }

    public Ingredient(int id, String name) {
        this.id = id;
        Name = name;
    }
}
