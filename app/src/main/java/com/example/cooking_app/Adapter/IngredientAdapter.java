package com.example.cooking_app.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cooking_app.Model.Ingredient;
import com.example.cooking_app.R;

import java.util.ArrayList;

public class IngredientAdapter extends RecyclerView.Adapter<IngredientAdapter.IngredientViewHolder> {
    private ArrayList<Ingredient> ingredients;
    private Context context;

    public IngredientAdapter(ArrayList<Ingredient> ingredients, Context context) {
        this.ingredients = ingredients;
        this.context = context;
    }

    @NonNull
    @Override
    public IngredientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_ingredient,parent,false);
        return new IngredientViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull IngredientViewHolder holder, int position) {
        Ingredient ingredient = ingredients.get(position);
        if(ingredient == null){
            return;
        }
        holder.name_ingredient.setText("- " + ingredient.getName() + " " + ingredient.getDecription());
    }

    @Override
    public int getItemCount() {
        if(ingredients != null){
            return ingredients.size();
        }
        return 0;
    }
    public class IngredientViewHolder extends RecyclerView.ViewHolder{
        TextView name_ingredient;

        public IngredientViewHolder(@NonNull View itemView) {
            super(itemView);
            name_ingredient = itemView.findViewById(R.id.name_ingredient);
        }
    }
}
