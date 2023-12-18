package com.example.cooking_app.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.cooking_app.Adapter.IngredientAdapter;
import com.example.cooking_app.Adapter.InstructionAdapter;
import com.example.cooking_app.Database.DBHandler;
import com.example.cooking_app.Model.Ingredient;
import com.example.cooking_app.Model.IngredientDetail;
import com.example.cooking_app.Model.Instruction;
import com.example.cooking_app.Model.Recipe;
import com.example.cooking_app.Model.User;
import com.example.cooking_app.R;

import java.util.ArrayList;

public class DetailRecipeActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private RecyclerView listIngredient;
    private RecyclerView listInstruction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);

        DBHandler dbHandler = new DBHandler(this);

        LinearLayout btnHome = findViewById(R.id.bt_home);
        LinearLayout btnMeal = findViewById(R.id.bt_meal);
        LinearLayout btnWishlist = findViewById(R.id.heart);
        LinearLayout btnSetting = findViewById(R.id.setting);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailRecipeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnMeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailRecipeActivity.this, CategoryActivity.class);
                startActivity(intent);
            }
        });

        btnWishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailRecipeActivity.this, WishListActivity.class);
                startActivity(intent);
            }
        });

        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailRecipeActivity.this, UserActivity.class);
                startActivity(intent);
            }
        });

        TextView wish = findViewById(R.id.wish);
        Drawable favorite = ContextCompat.getDrawable(this, R.drawable.baseline_favorite_24);
        Drawable unfavorite = ContextCompat.getDrawable(this, R.drawable.baseline_favorite_border_24);

        SharedPreferences preferences = getSharedPreferences("user_info", Context.MODE_PRIVATE);
        int userId = preferences.getInt("user_id",0);


        Bundle bundle = getIntent().getExtras();
        if(bundle == null){
            return;
        }
        Recipe recipe = (Recipe) bundle.get("object_recipe");
        TextView recipeName1 = findViewById(R.id.name1);
        recipeName1.setText(recipe.getNameRecipe());
        TextView recipeName2 = findViewById(R.id.name2);
        recipeName2.setText(recipe.getNameRecipe());
        TextView time = findViewById(R.id.time);
        time.setText(recipe.getTimeRecipe());
        TextView people = findViewById(R.id.people);
        people.setText(recipe.getPeopleRecipe() + " người");
        ImageView imageRecipe = findViewById(R.id.imageRecipe);
        int drawableReSourceId = getResources().getIdentifier(recipe.getImageRecipe(),"drawable",getPackageName());
        Glide.with(this).load(drawableReSourceId).into(imageRecipe);
        NguyenLieu(recipe);
        CongThuc(recipe);

        //Check recipe xem co trong danh sach yeu thich cua nguoi dung khong
        Boolean check = dbHandler.CheckWish(userId, recipe.getId());
        if (check == true)
        {
            wish.setCompoundDrawablesWithIntrinsicBounds(favorite, null, null, null);
        }
        else wish.setCompoundDrawablesWithIntrinsicBounds(unfavorite, null, null, null);

        //Add wishlist or delete wishlist
        wish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean checkFavorite = dbHandler.CheckWish(userId, recipe.getId());
                if (checkFavorite == false)
                {
                    try {
                        dbHandler.addWishList(userId, recipe.getId());
                        wish.setCompoundDrawablesWithIntrinsicBounds(favorite, null, null, null);
                        Toast.makeText(DetailRecipeActivity.this, "Đã thêm vào yêu thích!!!", Toast.LENGTH_SHORT).show();
                    } catch (Exception e)
                    {
                        Toast.makeText(DetailRecipeActivity.this, "Thất bại", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Boolean delete = dbHandler.deleteWishList(userId, recipe.getId());
                    if (delete == true)
                    {
                        wish.setCompoundDrawablesWithIntrinsicBounds(unfavorite, null, null, null);
                        Toast.makeText(DetailRecipeActivity.this, "Đã bỏ khỏi yêu thích!!", Toast.LENGTH_SHORT).show();
                    }
                    else Toast.makeText(DetailRecipeActivity.this, "Thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void CongThuc(Recipe recipe) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        listInstruction = findViewById(R.id.list_instruction);
        listInstruction.setLayoutManager(linearLayoutManager);
        ArrayList<Instruction> instructionList = new ArrayList<>();
        DBHandler dbHandler = new DBHandler(this);
        instructionList = dbHandler.getAllInstruction(recipe.getId());
        for(int i=0;i<instructionList.size()-1;i++){
            for(int j=i+1;j<instructionList.size();j++){
                if(instructionList.get(i).getStep() > instructionList.get(j).getStep()){
                    Instruction temp = instructionList.get(i);
                    instructionList.set(i, instructionList.get(j));
                    instructionList.set(j, temp);
                }
            }
        }
        adapter = new InstructionAdapter(this, instructionList);
        listInstruction.setAdapter(adapter);

    }

    private void NguyenLieu(Recipe recipe) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        listIngredient = findViewById(R.id.list_ingredient);
        listIngredient.setLayoutManager(linearLayoutManager);
        ArrayList<IngredientDetail> ingredientDetails = new ArrayList<>();
        DBHandler dbHandler = new DBHandler(this);
        ingredientDetails = dbHandler.getAllRecipeIngre(recipe.getId());
        adapter = new IngredientAdapter(ingredientDetails,this);
        listIngredient.setAdapter(adapter);
    }
}
