package com.example.cooking_app.Model;

import java.io.Serializable;

public class Recipe implements Serializable {
    private int id;
    private String nameRecipe;
    private String imageRecipe;

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

    public Recipe(int id, String nameRecipe, String imageRecipe) {
        this.id = id;
        this.nameRecipe = nameRecipe;
        this.imageRecipe = imageRecipe;
    }
}
