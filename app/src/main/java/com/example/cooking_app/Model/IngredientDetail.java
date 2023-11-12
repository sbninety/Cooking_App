package com.example.cooking_app.Model;

public class IngredientDetail {
    private Ingredient ingredient;
    private String decription;

    public IngredientDetail() {
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public IngredientDetail(Ingredient ingredient, String decription) {
        this.ingredient = ingredient;
        this.decription = decription;
    }
}
