package com.example.cooking_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Dish> listDish;
    DishListViewAdapter dishListViewAdapter;
    ListView listViewDish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listDish = new ArrayList<>();
        listDish.add(new Dish("1","chao","https://fastly.picsum.photos/id/0/5000/3333.jpg?hmac=_j6ghY5fCfSD6tvtcV74zXivkJSPIfR9B8w34XeQmvU",1));
        listDish.add(new Dish("2","chao","https://fastly.picsum.photos/id/0/5000/3333.jpg?hmac=_j6ghY5fCfSD6tvtcV74zXivkJSPIfR9B8w34XeQmvU",2));
        listDish.add(new Dish("3","chao","https://fastly.picsum.photos/id/0/5000/3333.jpg?hmac=_j6ghY5fCfSD6tvtcV74zXivkJSPIfR9B8w34XeQmvU",3));
        listDish.add(new Dish("4","chao","https://fastly.picsum.photos/id/0/5000/3333.jpg?hmac=_j6ghY5fCfSD6tvtcV74zXivkJSPIfR9B8w34XeQmvU",4));
        listDish.add(new Dish("5","chao","https://fastly.picsum.photos/id/0/5000/3333.jpg?hmac=_j6ghY5fCfSD6tvtcV74zXivkJSPIfR9B8w34XeQmvU",5));
        listDish.add(new Dish("6","chao","https://fastly.picsum.photos/id/0/5000/3333.jpg?hmac=_j6ghY5fCfSD6tvtcV74zXivkJSPIfR9B8w34XeQmvU",6));
        listDish.add(new Dish("7","chao","https://fastly.picsum.photos/id/0/5000/3333.jpg?hmac=_j6ghY5fCfSD6tvtcV74zXivkJSPIfR9B8w34XeQmvU",7));

        dishListViewAdapter = new DishListViewAdapter(listDish);

        listViewDish = findViewById(R.id.listDish);
        listViewDish.setAdapter(dishListViewAdapter);


        //Lắng nghe bắt sự kiện một phần tử danh sách được chọn
        listViewDish.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Dish dish = (Dish) dishListViewAdapter.getItem(position);
                //Làm gì đó khi chọn sản phẩm (ví dụ tạo một Activity hiện thị chi tiết, biên tập ..)
                Toast.makeText(MainActivity.this, dish.getName(), Toast.LENGTH_LONG).show();
            }
        });


    }
}