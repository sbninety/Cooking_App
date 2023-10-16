package com.example.cooking_app.Model;

public class Recipe {
    private String nameRecipe;
    private int image;

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

    public Recipe(String nameRecipe, int image) {
        this.nameRecipe = nameRecipe;
        this.image = image;
    }
}
