package com.example.cooking_app.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.cooking_app.Activity.MainActivity;
import com.example.cooking_app.Model.Recipe;
import com.example.cooking_app.R;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder> {

    private Context context;
    private ArrayList<Recipe> recipes;

    public RecipeAdapter(Context context) {
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_recipes, parent, false);
        return new  RecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {
        Recipe recipe = recipes.get(position);
        if (recipe == null)
        {
            return;
        }
        holder.imageRecipe.setImageResource(recipe.getImage());
        holder.nameRecipe.setText(recipe.getNameRecipe());
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


        public RecipeViewHolder(@NonNull View itemView) {
            super(itemView);
            imageRecipe = itemView.findViewById(R.id.image_recipe);
            nameRecipe = itemView.findViewById(R.id.name_recipe);
        }
    }
}
