package com.example.cooking_app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.cooking_app.Adapter.CategoryAdapter;
import com.example.cooking_app.Adapter.RecipeAdapter;
import com.example.cooking_app.Model.Category;
import com.example.cooking_app.Model.Recipe;
import com.example.cooking_app.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewCategoryList;
    private  RecyclerView recyclerViewRecipeList;
    private RecipeAdapter recipeAdapter;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerViewCategory();
        recyclerViewRecipe();
    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCategoryList = findViewById(R.id.view1);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category("title 1","dessert_orange_food_chocolate"));
        categoryList.add(new Category("title 2","dessert_orange_food_chocolate"));
        categoryList.add(new Category("title 3","dessert_orange_food_chocolate"));
        categoryList.add(new Category("title 4","dessert_orange_food_chocolate"));
        categoryList.add(new Category("title 5","dessert_orange_food_chocolate"));
        categoryList.add(new Category("title 6","dessert_orange_food_chocolate"));
        categoryList.add(new Category("title 7","dessert_orange_food_chocolate"));
        categoryList.add(new Category("title 8","dessert_orange_food_chocolate"));

        adapter = new CategoryAdapter(categoryList);
        recyclerViewCategoryList.setAdapter(adapter);
    }

    private void recyclerViewRecipe() {

        recyclerViewRecipeList = findViewById(R.id.view2);
        recipeAdapter = new RecipeAdapter(this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recyclerViewRecipeList.setLayoutManager(gridLayoutManager);

        ArrayList<Recipe> recipeList = new ArrayList<>();
        recipeList.add(new Recipe("title 1",R.drawable.anh3));
        recipeList.add(new Recipe("title 1",R.drawable.anh3));
        recipeList.add(new Recipe("title 1",R.drawable.anh3));
        recipeList.add(new Recipe("title 1",R.drawable.anh3));
        recipeList.add(new Recipe("title 1",R.drawable.anh3));
        recipeList.add(new Recipe("title 1",R.drawable.anh3));
        recipeList.add(new Recipe("title 1",R.drawable.anh3));
        recipeAdapter.setData(recipeList);
        recyclerViewRecipeList.setAdapter(recipeAdapter);
    }
}