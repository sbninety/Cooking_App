package com.example.cooking_app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.cooking_app.Adapter.CategoryAdapter;
import com.example.cooking_app.Adapter.RecipeByCategoryAdapter;
import com.example.cooking_app.Model.Category;
import com.example.cooking_app.Model.Recipe;
import com.example.cooking_app.R;

import java.util.ArrayList;

public class ListFoodByCategoryActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewCategoryList;
    private  RecyclerView recyclerViewRecipeList;
    private RecipeByCategoryAdapter recipeByCategoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_food_by_category);

        recyclerViewGetRecipesByCategory();
    }

    private void recyclerViewGetRecipesByCategory() {
        recyclerViewRecipeList = findViewById(R.id.recycler_view_recipe_by_category);
        recipeByCategoryAdapter = new RecipeByCategoryAdapter(this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
        recyclerViewRecipeList.setLayoutManager(gridLayoutManager);

        ArrayList<Recipe> recipeList = new ArrayList<>();
        recipeList.add(new Recipe("title 1",R.drawable.anh3, "Mien Bac"));
        recipeList.add(new Recipe("title 2",R.drawable.anh3, "Mien Nam"));
        recipeList.add(new Recipe("title 3",R.drawable.anh3, "Mien Nam"));
        recipeList.add(new Recipe("title 4",R.drawable.anh3, "Mien Nam"));
        recipeList.add(new Recipe("title 5",R.drawable.anh3, "Mien Nam"));
        recipeList.add(new Recipe("title 6",R.drawable.anh3, "Mien Nam"));
        recipeList.add(new Recipe("title 7",R.drawable.anh3, "Mien Nam"));
        recipeList.add(new Recipe("title 8",R.drawable.anh3, "Mien Nam"));
        recipeByCategoryAdapter.setData(recipeList);
        recyclerViewRecipeList.setAdapter(recipeByCategoryAdapter);
    }
}