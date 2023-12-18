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

        LinearLayout btnHome = findViewById(R.id.bt_home);
        LinearLayout btnMeal = findViewById(R.id.bt_meal);
        LinearLayout btnWishlist = findViewById(R.id.heart);
        LinearLayout btnSetting = findViewById(R.id.setting);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListFoodByCategoryActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnMeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListFoodByCategoryActivity.this, CategoryActivity.class);
                startActivity(intent);
            }
        });

        btnWishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListFoodByCategoryActivity.this, WishListActivity.class);
                startActivity(intent);
            }
        });

        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListFoodByCategoryActivity.this, UserActivity.class);
                startActivity(intent);
            }
        });

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