package com.example.cooking_app.Adapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cooking_app.Activity.ListFoodByCategoryActivity;
import com.example.cooking_app.Model.Category;
import com.example.cooking_app.R;

import android.content.Context;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.RecipeViewHolder> {

    private Context context;
    private ArrayList<Category> categories;

    public CategoryAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<Category> categories)
    {
        this.categories = categories;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_categories_item, parent, false);
        return new  RecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {
        Category category = categories.get(position);
        if (category == null)
        {
            return;
        }
        holder.nameCategory.setText(category.getName());
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickGoToDetail(category);
            }
        });
    }

    private void onClickGoToDetail(Category category) {
        Intent intent = new Intent(context, ListFoodByCategoryActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_category", category);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        if (categories != null)
            return categories.size();
        return 0;
    }

    public class RecipeViewHolder extends RecyclerView.ViewHolder {
        TextView nameCategory;
        ConstraintLayout mainLayout;

        public RecipeViewHolder(@NonNull View itemView) {
            super(itemView);
            nameCategory = itemView.findViewById(R.id.categoryName);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
