package com.example.cooking_app.Model;

public class Ingredient {
    private String Name;
    private String Decription;

    public Ingredient(String name, String decription) {
        Name = name;
        Decription = decription;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDecription() {
        return Decription;
    }

    public void setDecription(String decription) {
        Decription = decription;
    }
}
