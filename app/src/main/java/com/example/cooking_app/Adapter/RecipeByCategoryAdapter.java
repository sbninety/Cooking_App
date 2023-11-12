package com.example.cooking_app.Adapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.cooking_app.Activity.DetailRecipeActivity;
import com.example.cooking_app.Model.Recipe;
import com.example.cooking_app.R;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecipeByCategoryAdapter extends RecyclerView.Adapter<RecipeByCategoryAdapter.RecipeViewHolder> {

    private Context context;
    private ArrayList<Recipe> recipes;

    public RecipeByCategoryAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<Recipe> recipes)
    {
        this.recipes = recipes;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_item, parent, false);
        return new  RecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {
        Recipe recipe = recipes.get(position);
        if (recipe == null)
        {
            return;
        }
        int drawableReourceId = holder.itemView.getContext().getResources().getIdentifier(recipe.getImageRecipe(),"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableReourceId).into(holder.imageRecipe);
        holder.nameRecipe.setText(recipe.getNameRecipe());
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickGoToDetail(recipe);
            }
        });
    }
    private void onClickGoToDetail(Recipe recipe){
        Intent intent = new Intent(context, DetailRecipeActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_recipe", recipe);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }
    @Override
    public int getItemCount() {
        if (recipes != null)
            return recipes.size();
        return 0;
    }

    public class RecipeViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageRecipe;
        private TextView nameRecipe;
        ConstraintLayout mainLayout;

        public RecipeViewHolder(@NonNull View itemView) {
            super(itemView);
            imageRecipe = itemView.findViewById(R.id.recipeImage);
            nameRecipe = itemView.findViewById(R.id.recipeName);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
