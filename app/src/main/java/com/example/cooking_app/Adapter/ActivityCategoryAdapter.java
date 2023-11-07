package com.example.cooking_app.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.cooking_app.Activity.MainActivity;
import com.example.cooking_app.Model.Category;
import com.example.cooking_app.Model.Recipe;
import com.example.cooking_app.R;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ActivityCategoryAdapter extends RecyclerView.Adapter<ActivityCategoryAdapter.RecipeViewHolder> {

    private Context context;
    private ArrayList<Category> categories;

    public ActivityCategoryAdapter(Context context) {
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
        holder.nameCategory.setText(category.getTitle());
    }

    @Override
    public int getItemCount() {
        if (categories != null)
            return categories.size();
        return 0;
    }

    public class RecipeViewHolder extends RecyclerView.ViewHolder {
        private TextView nameCategory;


        public RecipeViewHolder(@NonNull View itemView) {
            super(itemView);
            nameCategory = itemView.findViewById(R.id.categoryName);
        }
    }
}
