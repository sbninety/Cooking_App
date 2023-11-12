package com.example.cooking_app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.cooking_app.Adapter.CategoryAdapter;
import com.example.cooking_app.Adapter.RecipeByCategoryAdapter;
import com.example.cooking_app.Database.DBHandler;
import com.example.cooking_app.Model.Category;
import com.example.cooking_app.Model.Recipe;
import com.example.cooking_app.R;

import java.util.ArrayList;

public class ListFoodByCategoryActivity extends AppCompatActivity {
    private  RecyclerView recyclerViewRecipeList;
    private RecipeByCategoryAdapter recipeByCategoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_food_by_category);
        Bundle bundle = getIntent().getExtras();
        if(bundle == null){
            return;
        }
        Category category = (Category) bundle.get("object_category");
        TextView nameCat = findViewById(R.id.nameCategory);
        nameCat.setText(category.getName());
        recyclerViewGetRecipesByCategory(category);
    }

    private void recyclerViewGetRecipesByCategory(Category category) {
        recyclerViewRecipeList = findViewById(R.id.recycler_view_recipe_by_category);
        recipeByCategoryAdapter = new RecipeByCategoryAdapter(this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
        recyclerViewRecipeList.setLayoutManager(gridLayoutManager);

        ArrayList<Recipe> recipeList = new ArrayList<>();
        DBHandler dbHandler = new DBHandler(this);
        recipeList = dbHandler.listRecipebyCat(category.getId());
        recipeByCategoryAdapter.setData(recipeList);
        recyclerViewRecipeList.setAdapter(recipeByCategoryAdapter);
    }
}