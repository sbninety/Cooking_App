package com.example.cooking_app.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.cooking_app.Activity.DetailRecipeActivity;
import com.example.cooking_app.Model.Recipe;
import com.example.cooking_app.R;

import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder> implements Filterable {

    private ArrayList<Recipe> recipes;
    private ArrayList<Recipe> recipesOld;
    private Context context;

    public RecipeAdapter(Context context,ArrayList<Recipe> recipes) {
        this.context = context;
        this.recipes = recipes;
        this.recipesOld = recipes;
    }
    public RecipeAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public RecipeAdapter.RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_item,parent,false);
        return new RecipeViewHolder(inflate);
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

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String keyWords = charSequence.toString();
                if (keyWords.isEmpty()) {
                    recipes = recipesOld;
                } else {
                    ArrayList<Recipe> list = new ArrayList<>();
                    for (Recipe recipe : recipesOld) {
                        if(recipe.getNameRecipe().toLowerCase().contains(keyWords.toLowerCase())){
                            list.add(recipe);
                        }
                    }

                    recipes = list;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = recipes;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                recipes = (ArrayList<Recipe>)filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class RecipeViewHolder extends RecyclerView.ViewHolder {
        TextView nameRecipe;
        ImageView imageRecipe;
        ConstraintLayout mainLayout;
        public RecipeViewHolder(@NonNull View itemView) {
            super(itemView);
            nameRecipe = itemView.findViewById(R.id.recipeName);
            imageRecipe = itemView.findViewById(R.id.recipeImage);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
