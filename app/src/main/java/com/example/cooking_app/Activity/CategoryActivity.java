package com.example.cooking_app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cooking_app.Adapter.CategoryAdapter;
import com.example.cooking_app.Database.DBHandler;
import com.example.cooking_app.Model.Category;
import com.example.cooking_app.R;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity {

    private RecyclerView recyclerViewCategoryList;
    private CategoryAdapter categoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        LinearLayout btnHome = findViewById(R.id.bt_home);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CategoryActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        recyclerViewCategory();
    }

    private void recyclerViewCategory() {
        recyclerViewCategoryList = findViewById(R.id.recycler_view);
        categoryAdapter = new CategoryAdapter(this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,1);
        recyclerViewCategoryList.setLayoutManager(gridLayoutManager);

        ArrayList<Category> categoryList = new ArrayList<>();
        DBHandler dbHandler = new DBHandler(this);
        categoryList = dbHandler.getAllCategory();
        categoryAdapter.setData(categoryList);
        recyclerViewCategoryList.setAdapter(categoryAdapter);
    }
}