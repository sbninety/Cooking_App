package com.example.cooking_app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.cooking_app.Adapter.CategoryAdapter;
import com.example.cooking_app.Model.Category;
import com.example.cooking_app.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewCategoryList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCategory();
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
}