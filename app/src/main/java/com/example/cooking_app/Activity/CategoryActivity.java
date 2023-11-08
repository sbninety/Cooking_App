package com.example.cooking_app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.cooking_app.Adapter.CategoryAdapter;
import com.example.cooking_app.Model.Category;
import com.example.cooking_app.R;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewCategoryList;
    private  RecyclerView recyclerViewRecipeList;
    private CategoryAdapter categoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        recyclerViewCategory();
    }

    private void recyclerViewCategory() {
        recyclerViewRecipeList = findViewById(R.id.recycler_view);
        categoryAdapter = new CategoryAdapter(this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,1);
        recyclerViewRecipeList.setLayoutManager(gridLayoutManager);

        ArrayList<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category("title 1","dessert_orange_food_chocolate"));
        categoryList.add(new Category("title 2","dessert_orange_food_chocolate"));
        categoryList.add(new Category("title 3","dessert_orange_food_chocolate"));
        categoryList.add(new Category("title 4","dessert_orange_food_chocolate"));
        categoryList.add(new Category("title 5","dessert_orange_food_chocolate"));
        categoryList.add(new Category("title 6","dessert_orange_food_chocolate"));
        categoryList.add(new Category("title 7","dessert_orange_food_chocolate"));
        categoryList.add(new Category("title 8","dessert_orange_food_chocolate"));
        categoryAdapter.setData(categoryList);
        recyclerViewRecipeList.setAdapter(categoryAdapter);
    }
}