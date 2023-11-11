package com.example.cooking_app.Adapter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.cooking_app.Fragment.SliderFragment;
import com.example.cooking_app.Model.Recipe;
import com.example.cooking_app.Model.Slider;

import java.util.List;

public class SliderAdapter extends FragmentStateAdapter {
    private List<Recipe> listSlider;
    public SliderAdapter(@NonNull FragmentActivity fragmentActivity, List<Recipe> list) {
        super(fragmentActivity);
        this.listSlider = list;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Recipe recipe = listSlider.get(position);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_slider", recipe);
        SliderFragment sliderFragment = new SliderFragment();
        sliderFragment.setArguments(bundle);
        return sliderFragment;
    }

    @Override
    public int getItemCount() {
        if(listSlider != null){
            return listSlider.size();
        }
        return 0;
    }
}
