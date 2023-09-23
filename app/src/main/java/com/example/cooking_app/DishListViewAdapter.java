package com.example.cooking_app;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class DishListViewAdapter extends BaseAdapter
{
    final ArrayList<Dish> listDish;

    DishListViewAdapter(ArrayList<Dish> listDish) {
        this.listDish = listDish;
    }

    @Override
    public int getCount() {
        //Trả về tổng số phần tử, nó được gọi bởi ListView
        return listDish.size();
    }

    @Override
    public Object getItem(int position) {
        //Trả về dữ liệu ở vị trí position của Adapter, tương ứng là phần tử
        //có chỉ số position trong listProduct
        return listDish.get(position);
    }

    @Override
    public long getItemId(int position) {
        //Trả về một ID của phần
        return listDish.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewProduct;
        if (convertView == null) {
            viewProduct = View.inflate(parent.getContext(), R.layout.item_layout, null);
        } else viewProduct = convertView;

        Dish dish = (Dish) getItem(position);
        ((TextView) viewProduct.findViewById(R.id.image)).setText(String.format("Hinh anh : %d",dish.getImage()));
        ((TextView) viewProduct.findViewById(R.id.name)).setText(String.format("Tên SP : %s", dish.getName()));
        ((TextView) viewProduct.findViewById(R.id.time)).setText(String.format("Giá %d", dish.getTime()));
        return viewProduct;
    }
}
