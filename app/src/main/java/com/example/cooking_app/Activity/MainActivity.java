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
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cooking_app.Adapter.CategoryAdapter;
import com.example.cooking_app.Adapter.RecipeAdapter;
import com.example.cooking_app.Adapter.SliderAdapter;
import com.example.cooking_app.Database.DBHandler;
import com.example.cooking_app.Model.Category;
import com.example.cooking_app.Model.Recipe;
import com.example.cooking_app.Model.Slider;
import com.example.cooking_app.Model.User;
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
        LinearLayout btnMeal = findViewById(R.id.bt_meal);
        LinearLayout btnHeart = findViewById(R.id.heart);
        LinearLayout setting = findViewById(R.id.setting);
        TextView btBac = findViewById(R.id.bt_bac);
        TextView btTrung = findViewById(R.id.bt_trung);
        TextView btNam = findViewById(R.id.bt_nam);
        ImageView iconSearch = findViewById(R.id.search_icon);
        btnMeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CategoryActivity.class);
                startActivity(intent);
            }
        });

        btnHeart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, WishListActivity.class);
                startActivity(intent);
            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, UserActivity.class);
                startActivity(intent);
            }
        });
        btBac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListFoodByCategoryActivity.class);
                Bundle bundle = new Bundle();
                DBHandler dbHandler = new DBHandler(MainActivity.this);
                Category category = dbHandler.getCategory(1);
                bundle.putSerializable("object_category", category);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btTrung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListFoodByCategoryActivity.class);
                Bundle bundle = new Bundle();
                DBHandler dbHandler = new DBHandler(MainActivity.this);
                Category category = dbHandler.getCategory(2);
                bundle.putSerializable("object_category", category);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btNam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListFoodByCategoryActivity.class);
                Bundle bundle = new Bundle();
                DBHandler dbHandler = new DBHandler(MainActivity.this);
                Category category = dbHandler.getCategory(3);
                bundle.putSerializable("object_category", category);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        iconSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });

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
//        recipeList.add(new Recipe(1,"Ga xao xa ot","dessert_orange_food_chocolate"));
        DBHandler dbHandler = new DBHandler(this);
        recipeList = dbHandler.listRecipebyCat(3);
        adapter = new RecipeAdapter(this,recipeList);
        listMonAnMienNam.setAdapter(adapter);
    }

    private void monAnMienTrung() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        listMonAnMienTrung = findViewById(R.id.view2);
        listMonAnMienTrung.setLayoutManager(linearLayoutManager);

        ArrayList<Recipe> recipeList = new ArrayList<>();
//        recipeList.add(new Recipe(1,"Ga xao xa ot","dessert_orange_food_chocolate"));
        DBHandler dbHandler = new DBHandler(this);
        recipeList = dbHandler.listRecipebyCat(2);
        adapter = new RecipeAdapter(this,recipeList);
        listMonAnMienTrung.setAdapter(adapter);
    }

    private void slider() {
        viewPager2 = findViewById(R.id.view_pager_2);
        circleIndicator3 = findViewById(R.id.circle_indicator);
        List<Recipe> list = new ArrayList<>();
        DBHandler dbHandler = new DBHandler(this);
        list = dbHandler.getSlider();
        SliderAdapter sliderAdapter = new SliderAdapter(this, list);
        viewPager2.setAdapter(sliderAdapter);
        circleIndicator3.setViewPager(viewPager2);
    }

    private void monAnMienBac() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        listMonAnMienBac = findViewById(R.id.view1);
        listMonAnMienBac.setLayoutManager(linearLayoutManager);

        ArrayList<Recipe> recipeList = new ArrayList<>();
//        recipeList.add(new Recipe(1,"Ga xao xa ot","dessert_orange_food_chocolate"));
        DBHandler dbHandler = new DBHandler(this);
        recipeList = dbHandler.listRecipebyCat(1);
        adapter = new RecipeAdapter(this,recipeList);
        listMonAnMienBac.setAdapter(adapter);
    }

}