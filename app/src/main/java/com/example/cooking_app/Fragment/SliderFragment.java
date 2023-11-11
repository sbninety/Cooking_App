package com.example.cooking_app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.cooking_app.Activity.MainActivity;
import com.example.cooking_app.Model.Recipe;
import com.example.cooking_app.Model.Slider;
import com.example.cooking_app.R;

public class SliderFragment extends Fragment {
    private View mView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_slider, container, false);
        Bundle bundle = getArguments();
        Recipe recipe = (Recipe) bundle.get("object_slider");
        ImageView imageSlider = mView.findViewById(R.id.img_slider);
        int drawableReourceId = this.getResources().getIdentifier(recipe.getImageRecipe(),"drawable", this.getActivity().getPackageName());
        Glide.with(this).load(drawableReourceId).into(imageSlider);
        return mView;
    }
}
