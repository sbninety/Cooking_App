package com.example.cooking_app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

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