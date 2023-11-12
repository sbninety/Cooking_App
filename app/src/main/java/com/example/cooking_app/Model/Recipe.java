package com.example.cooking_app.Model;

import java.io.Serializable;

public class Recipe implements Serializable {
    private int id;
    private String nameRecipe;
    private String imageRecipe;
    private String timeRecipe;
    private String peopleRecipe;

    public String getTimeRecipe() {
        return timeRecipe;
    }

    public void setTimeRecipe(String timeRecipe) {
        this.timeRecipe = timeRecipe;
    }

    public String getPeopleRecipe() {
        return peopleRecipe;
    }

    public void setPeopleRecipe(String peopleRecipe) {
        this.peopleRecipe = peopleRecipe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameRecipe() {
        return nameRecipe;
    }

    public void setNameRecipe(String nameRecipe) {
        this.nameRecipe = nameRecipe;
    }

    public String getImageRecipe() {
        return imageRecipe;
    }

    public void setImageRecipe(String imageRecipe) {
        this.imageRecipe = imageRecipe;
    }

    public Recipe() {
    }

    public Recipe(int id, String nameRecipe, String imageRecipe, String timeRecipe, String peopleRecipe) {
        this.id = id;
        this.nameRecipe = nameRecipe;
        this.imageRecipe = imageRecipe;
        this.timeRecipe = timeRecipe;
        this.peopleRecipe = peopleRecipe;
    }
}
