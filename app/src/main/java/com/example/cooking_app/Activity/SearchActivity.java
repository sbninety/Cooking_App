package com.example.cooking_app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.cooking_app.Adapter.RecipeAdapter;
import com.example.cooking_app.Database.DBHandler;
import com.example.cooking_app.Model.Recipe;
import com.example.cooking_app.R;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {
    private RecipeAdapter recipeAdapter;
    private SearchView searchView;
    private RecyclerView listMonAnMienTrung;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

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
        listMonAnMienTrung = findViewById(R.id.search_list);
        listMonAnMienTrung.setLayoutManager(gridLayoutManager);
        ArrayList<Recipe> recipeList = new ArrayList<>();
        listMonAnMienTrung.setAdapter(adapter);
    }
}