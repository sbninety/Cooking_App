package com.example.cooking_app.Model;

import java.io.Serializable;

public class Recipe implements Serializable {
    private String nameRecipe;
    private int image;

    private String category;

    public String getNameRecipe() {
        return nameRecipe;
    }

    public void setNameRecipe(String nameRecipe) {
        this.nameRecipe = nameRecipe;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public Recipe(String nameRecipe, int image, String category) {
        this.nameRecipe = nameRecipe;
        this.image = image;
        this.category = category;
    }
}
