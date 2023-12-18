package com.example.cooking_app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.cooking_app.Adapter.RecipeAdapter;
import com.example.cooking_app.Database.DBHandler;
import com.example.cooking_app.Model.Recipe;
import com.example.cooking_app.R;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {
    private RecipeAdapter recipeAdapter;
    private SearchView searchView;
    private RecyclerView listMonAn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        LinearLayout btnHome = findViewById(R.id.bt_home);
        LinearLayout btnMeal = findViewById(R.id.bt_meal);
        LinearLayout btnWishlist = findViewById(R.id.heart);
        LinearLayout btnSetting = findViewById(R.id.setting);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnMeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchActivity.this, CategoryActivity.class);
                startActivity(intent);
            }
        });

        btnWishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchActivity.this, WishListActivity.class);
                startActivity(intent);
            }
        });

        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchActivity.this, UserActivity.class);
                startActivity(intent);
            }
        });

        ArrayList<Recipe> recipeList = new ArrayList<>();
        DBHandler dbHandler = new DBHandler(this);
        recipeList = dbHandler.getAllRecipe();
        recipeAdapter = new RecipeAdapter(this,recipeList);
        monAn(recipeAdapter);

        searchView = findViewById(R.id.search);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                recipeAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                recipeAdapter.getFilter().filter(newText);
                return false;
            }
        });
    }

    private void monAn(RecipeAdapter adapter) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        listMonAn = findViewById(R.id.search_list);
        listMonAn.setLayoutManager(gridLayoutManager);
        listMonAn.setAdapter(adapter);
    }
}