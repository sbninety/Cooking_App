package com.example.cooking_app.Activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.cooking_app.Model.Recipe;
import com.example.cooking_app.R;

public class DetailRecipeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
        Bundle bundle = getIntent().getExtras();
        if(bundle == null){
            return;
        }
        Recipe recipe = (Recipe) bundle.get("object_recipe");
        TextView recipeName = findViewById(R.id.textView);
        ImageView recipeImage = findViewById(R.id.imageView);
        recipeName.setText(recipe.getNameRecipe());
        recipeImage.setImageResource(recipe.getImage());
    }
}
