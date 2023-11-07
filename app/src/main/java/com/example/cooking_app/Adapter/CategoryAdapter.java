package com.example.cooking_app.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.cooking_app.Model.Category;
import com.example.cooking_app.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    ArrayList<Category> categories;

    public CategoryAdapter(ArrayList<Category> categories) {
        this.categories = categories;
    }

    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder holder, int position) {
        holder.categoryName.setText(categories.get(position).getTitle());
        String imageUrl = "";
        switch (position){
            case 0:{
                imageUrl = "dessert_orange_food_chocolate";
                break;
            }
            case 1:{
                imageUrl = "dessert_orange_food_chocolate";
                break;
            }
            case 2:{
                imageUrl = "dessert_orange_food_chocolate";
                break;
            }
            case 3:{
                imageUrl = "dessert_orange_food_chocolate";
                break;
            }
            case 4:{
                imageUrl = "dessert_orange_food_chocolate";
                break;
            }
            case 5:{
                imageUrl = "dessert_orange_food_chocolate";
                break;
            }
            case 6:{
                imageUrl = "dessert_orange_food_chocolate";
                break;
            }
            case 7:{
                imageUrl = "dessert_orange_food_chocolate";
                break;
            }
        }
        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(imageUrl,"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.categoryImage);
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView categoryName;
        ImageView categoryImage;
        ConstraintLayout mainLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryName = itemView.findViewById(R.id.categoryName);
            categoryImage = itemView.findViewById(R.id.categoryImage);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
