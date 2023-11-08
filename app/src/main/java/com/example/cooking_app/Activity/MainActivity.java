package com.example.cooking_app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.cooking_app.Adapter.CategoryAdapter;
import com.example.cooking_app.Adapter.RecipeAdapter;
import com.example.cooking_app.Adapter.SliderAdapter;
import com.example.cooking_app.Model.Category;
import com.example.cooking_app.Model.Recipe;
import com.example.cooking_app.Model.Slider;
import com.example.cooking_app.R;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator3;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewCategoryList;
    private  RecyclerView recyclerViewRecipeList;
    private RecipeAdapter recipeAdapter;
    private ViewPager2 viewPager2;
    private CircleIndicator3 circleIndicator3;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout btnStart = findViewById(R.id.bt_meal);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CategoryActivity.class);
                startActivity(intent);
            }
        });

        recyclerViewRecipe();
        slider();
    }

    private void slider() {
        viewPager2 = findViewById(R.id.view_pager_2);
        circleIndicator3 = findViewById(R.id.circle_indicator);
        List<Slider> list = new ArrayList<>();
        list.add(new Slider(R.drawable.dessert_orange_food_chocolate));
        list.add(new Slider(R.drawable.dessert_orange_food_chocolate));
        list.add(new Slider(R.drawable.dessert_orange_food_chocolate));
        list.add(new Slider(R.drawable.dessert_orange_food_chocolate));
        list.add(new Slider(R.drawable.dessert_orange_food_chocolate));
        SliderAdapter sliderAdapter = new SliderAdapter(this, list);
        viewPager2.setAdapter(sliderAdapter);
        circleIndicator3.setViewPager(viewPager2);
    }


    private void recyclerViewRecipe() {

        recyclerViewRecipeList = findViewById(R.id.view2);
        recipeAdapter = new RecipeAdapter(this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recyclerViewRecipeList.setLayoutManager(gridLayoutManager);

        ArrayList<Recipe> recipeList = new ArrayList<>();
        recipeList.add(new Recipe("title 1",R.drawable.anh3, ""));
        recipeList.add(new Recipe("title 1",R.drawable.anh3, ""));
        recipeList.add(new Recipe("title 1",R.drawable.anh3, ""));
        recipeList.add(new Recipe("title 1",R.drawable.anh3, ""));
        recipeList.add(new Recipe("title 1",R.drawable.anh3, ""));
        recipeList.add(new Recipe("title 1",R.drawable.anh3, ""));
        recipeList.add(new Recipe("title 1",R.drawable.anh3, ""));
        recipeAdapter.setData(recipeList);
        recyclerViewRecipeList.setAdapter(recipeAdapter);
    }
}