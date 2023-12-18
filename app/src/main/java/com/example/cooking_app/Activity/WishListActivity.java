package com.example.cooking_app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.cooking_app.Adapter.RecipeAdapter;
import com.example.cooking_app.Database.DBHandler;
import com.example.cooking_app.Model.Recipe;
import com.example.cooking_app.R;

import java.util.ArrayList;

public class WishListActivity extends AppCompatActivity {
    private RecipeAdapter recipeAdapter;
    private RecyclerView listMonAn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish_list);

        LinearLayout btnHome = findViewById(R.id.bt_home);
        LinearLayout btnMeal = findViewById(R.id.bt_meal);
        LinearLayout btnSetting = findViewById(R.id.setting);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WishListActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnMeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WishListActivity.this, CategoryActivity.class);
                startActivity(intent);
            }
        });


        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WishListActivity.this, UserActivity.class);
                startActivity(intent);
            }
        });

        SharedPreferences preferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        int userId = preferences.getInt("user_id",0);

        ArrayList<Recipe> recipeList = new ArrayList<>();
        DBHandler dbHandler = new DBHandler(this);
        recipeList =  dbHandler.getWishList(userId);
        recipeAdapter = new RecipeAdapter(this,recipeList);
        monAn(recipeAdapter);
    }

    private void monAn(RecipeAdapter adapter) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        listMonAn = findViewById(R.id.wish_list);
        listMonAn.setLayoutManager(gridLayoutManager);
        listMonAn.setAdapter(adapter);
    }
}