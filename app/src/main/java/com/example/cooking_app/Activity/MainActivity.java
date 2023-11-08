package com.example.cooking_app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridLayout;
import android.widget.GridView;
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
    private RecyclerView listMonAnMienBac;
    private RecyclerView listMonAnMienTrung;
    private RecyclerView listMonAnMienNam;
    private ViewPager2 viewPager2;
    private CircleIndicator3 circleIndicator3;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        monAnMienBac();
        monAnMienTrung();
        monAnMienNam();
        slider();
    }

    private void monAnMienNam() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        listMonAnMienNam = findViewById(R.id.view3);
        listMonAnMienNam.setLayoutManager(linearLayoutManager);

        ArrayList<Recipe> recipeList = new ArrayList<>();
        recipeList.add(new Recipe("Gà xào xả ớt",R.drawable.dessert_orange_food_chocolate,""));
        recipeList.add(new Recipe("title 2",R.drawable.dessert_orange_food_chocolate,""));
        recipeList.add(new Recipe("title 3",R.drawable.dessert_orange_food_chocolate,""));
        recipeList.add(new Recipe("title 4",R.drawable.dessert_orange_food_chocolate,""));
        recipeList.add(new Recipe("title 5",R.drawable.dessert_orange_food_chocolate,""));
        recipeList.add(new Recipe("title 6",R.drawable.dessert_orange_food_chocolate,""));
        recipeList.add(new Recipe("title 7",R.drawable.dessert_orange_food_chocolate,""));
        recipeList.add(new Recipe("title 8",R.drawable.dessert_orange_food_chocolate,""));

        adapter = new RecipeAdapter(this,recipeList);
        listMonAnMienNam.setAdapter(adapter);
    }

    private void monAnMienTrung() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        listMonAnMienTrung = findViewById(R.id.view2);
        listMonAnMienTrung.setLayoutManager(linearLayoutManager);

        ArrayList<Recipe> recipeList = new ArrayList<>();
        recipeList.add(new Recipe("Gà xào xả ớt",R.drawable.dessert_orange_food_chocolate,""));
        recipeList.add(new Recipe("title 2",R.drawable.dessert_orange_food_chocolate,""));
        recipeList.add(new Recipe("title 3",R.drawable.dessert_orange_food_chocolate,""));
        recipeList.add(new Recipe("title 4",R.drawable.dessert_orange_food_chocolate,""));
        recipeList.add(new Recipe("title 5",R.drawable.dessert_orange_food_chocolate,""));
        recipeList.add(new Recipe("title 6",R.drawable.dessert_orange_food_chocolate,""));
        recipeList.add(new Recipe("title 7",R.drawable.dessert_orange_food_chocolate,""));
        recipeList.add(new Recipe("title 8",R.drawable.dessert_orange_food_chocolate,""));

        adapter = new RecipeAdapter(this,recipeList);
        listMonAnMienTrung.setAdapter(adapter);
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

    private void monAnMienBac() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        listMonAnMienBac = findViewById(R.id.view1);
        listMonAnMienBac.setLayoutManager(linearLayoutManager);

        ArrayList<Recipe> recipeList = new ArrayList<>();
        recipeList.add(new Recipe("Gà xào xả ớt",R.drawable.dessert_orange_food_chocolate,""));
        recipeList.add(new Recipe("title 2",R.drawable.dessert_orange_food_chocolate,""));
        recipeList.add(new Recipe("title 3",R.drawable.dessert_orange_food_chocolate,""));
        recipeList.add(new Recipe("title 4",R.drawable.dessert_orange_food_chocolate,""));
        recipeList.add(new Recipe("title 5",R.drawable.dessert_orange_food_chocolate,""));
        recipeList.add(new Recipe("title 6",R.drawable.dessert_orange_food_chocolate,""));
        recipeList.add(new Recipe("title 7",R.drawable.dessert_orange_food_chocolate,""));
        recipeList.add(new Recipe("title 8",R.drawable.dessert_orange_food_chocolate,""));

        adapter = new RecipeAdapter(this,recipeList);
        listMonAnMienBac.setAdapter(adapter);
    }

}