package com.example.cooking_app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cooking_app.Adapter.CategoryAdapter;
import com.example.cooking_app.Adapter.RecipeAdapter;
import com.example.cooking_app.Adapter.SliderAdapter;
import com.example.cooking_app.Database.DBHandler;
import com.example.cooking_app.Model.Category;
import com.example.cooking_app.Model.Recipe;
import com.example.cooking_app.Model.Slider;
import com.example.cooking_app.R;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator3;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private RecyclerView listMonAnMienBac;
    private RecyclerView listMonAnMienTrung;
    private RecyclerView listMonAnMienNam;
    private ViewPager2 viewPager2;
    private CircleIndicator3 circleIndicator3;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout btnMeal = findViewById(R.id.bt_meal);
        TextView btBac = findViewById(R.id.bt_bac);
        TextView btTrung = findViewById(R.id.bt_trung);
        TextView btNam = findViewById(R.id.bt_nam);
        btnMeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CategoryActivity.class);
                startActivity(intent);
            }
        });
        btBac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListFoodByCategoryActivity.class);
                Bundle bundle = new Bundle();
                DBHandler dbHandler = new DBHandler(MainActivity.this);
                Category category = dbHandler.getCategory(1);
                bundle.putSerializable("object_category", category);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btTrung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListFoodByCategoryActivity.class);
                Bundle bundle = new Bundle();
                DBHandler dbHandler = new DBHandler(MainActivity.this);
                Category category = dbHandler.getCategory(2);
                bundle.putSerializable("object_category", category);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btNam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListFoodByCategoryActivity.class);
                Bundle bundle = new Bundle();
                DBHandler dbHandler = new DBHandler(MainActivity.this);
                Category category = dbHandler.getCategory(3);
                bundle.putSerializable("object_category", category);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
//        DBHandler dbHandler = new DBHandler(this);
//        dbHandler.addCategory("Món ăn miền Bắc");
//        dbHandler.addCategory("Món ăn miền Trung");
//        dbHandler.addCategory("Món ăn miền Nam");
//        dbHandler.addRecipe("Thịt lợn kho","anh2","60 phút", "1");
//        dbHandler.addRecipe("Thịt gà kho","anh3","70 phút", "2");
//        dbHandler.addRecipe("Thịt bò kho","anh4","80 phút", "3");
//        dbHandler.addRecipe("Thịt cá kho","dessert_orange_food_chocolate","90 phút", "4");
//        dbHandler.addRecipeCategory(1,1);
//        dbHandler.addRecipeCategory(2,2);
//        dbHandler.addRecipeCategory(3,3);
//        dbHandler.addRecipeCategory(1,4);
//
//        dbHandler.addIngredient("Thịt heo");
//        dbHandler.addIngredient("Hành tím");
//        dbHandler.addIngredient("Tỏi");
//        dbHandler.addIngredient("Hành lá");
//        dbHandler.addIngredient("Ớt");
//        dbHandler.addIngredient("Đường");
//        dbHandler.addIngredient("Muối");
//        dbHandler.addIngredient("Bột ngọt");
//        dbHandler.addIngredient("Hạt nêm");
//        dbHandler.addIngredient("Nước mắm");
//        dbHandler.addIngredient("Dầu ăn");
//        dbHandler.addIngredient("Tiêu");
//        dbHandler.addIngredient("Cá");
//        dbHandler.addIngredient("Nước dừa");
//        dbHandler.addIngredient("Gừng");
//        dbHandler.addIngredient("Giấm");
//        dbHandler.addIngredient("Ức gà");
//        dbHandler.addIngredient("Thịt bò");
//        dbHandler.addIngredient("Sả");
//        dbHandler.addIngredient("Tương ớt");
//
//        dbHandler.addRecipeIngredient(1,1,"400g");
//        dbHandler.addRecipeIngredient(1,2,"");
//        dbHandler.addRecipeIngredient(1,3,"");
//        dbHandler.addRecipeIngredient(1,4,"");
//        dbHandler.addRecipeIngredient(1,5,"");
//        dbHandler.addRecipeIngredient(1,6,"");
//        dbHandler.addRecipeIngredient(1,7,"");
//        dbHandler.addRecipeIngredient(1,8,"");
//        dbHandler.addRecipeIngredient(1,9,"");
//        dbHandler.addRecipeIngredient(1,10,"");
//        dbHandler.addRecipeIngredient(1,11,"");
//        dbHandler.addRecipeIngredient(1,12,"");
//        dbHandler.addRecipeIngredient(4,1,"100g");
//        dbHandler.addRecipeIngredient(4,13,"400g");
//        dbHandler.addRecipeIngredient(4,14,"150ml");
//        dbHandler.addRecipeIngredient(4,2,"");
//        dbHandler.addRecipeIngredient(4,4,"");
//        dbHandler.addRecipeIngredient(4,15,"");
//        dbHandler.addRecipeIngredient(4,3,"");
//        dbHandler.addRecipeIngredient(4,5,"");
//        dbHandler.addRecipeIngredient(4,10,"");
//        dbHandler.addRecipeIngredient(4,11,"");
//        dbHandler.addRecipeIngredient(4,16,"");
//        dbHandler.addRecipeIngredient(4,12,"");
//        dbHandler.addRecipeIngredient(2,17,"300g");
//        dbHandler.addRecipeIngredient(2,12,"");
//        dbHandler.addRecipeIngredient(2,3,"");
//        dbHandler.addRecipeIngredient(2,5,"");
//        dbHandler.addRecipeIngredient(2,4,"");
//        dbHandler.addRecipeIngredient(2,10,"");
//        dbHandler.addRecipeIngredient(2,11,"");
//        dbHandler.addRecipeIngredient(2,16,"");
//        dbHandler.addRecipeIngredient(2,6,"");
//        dbHandler.addRecipeIngredient(2,8,"");
//        dbHandler.addRecipeIngredient(2,9,"");
//        dbHandler.addRecipeIngredient(3,18,"400g");
//        dbHandler.addRecipeIngredient(3,12,"");
//        dbHandler.addRecipeIngredient(3,11,"");
//        dbHandler.addRecipeIngredient(3,2,"");
//        dbHandler.addRecipeIngredient(3,3,"");
//        dbHandler.addRecipeIngredient(3,5,"");
//        dbHandler.addRecipeIngredient(3,19,"");
//        dbHandler.addRecipeIngredient(3,20,"");
//        dbHandler.addRecipeIngredient(3,9,"");
//
//        dbHandler.addInstruction(1,1,"Rửa sạch thịt heo với nước sạch, sau đó cắt thành từng miếng vừa ăn. Với món này bạn có thể sử dụng thịt ba chỉ hay thịt nạc đều ngon.");
//        dbHandler.addInstruction(1,2,"Hành tím và tỏi lột vỏ, rồi cắt lát mỏng, nếu thích bạn cũng có thể băm nhuyễn cũng được nha.");
//        dbHandler.addInstruction(1,3,"Hành lá và ớt rửa sạch, hành lá thì cắt nhỏ, ớt bạn có thể để nguyên trái hoặc cắt nhỏ tùy theo sở thích ăn cay của mình.");
//        dbHandler.addInstruction(1,4,"Cho thịt heo vào một cái tô cùng với một ít nước mắm, đường, hạt nêm, tiêu và muối, trộn đều rồi ướp trong 15 phút cho thịt thấm gia vị. Để thịt lên màu đẹp hơn thì bạn nên sử dụng đường vàng khi kho nhé.");
//        dbHandler.addInstruction(1,5,"Bắc một cái chảo lên bếp, sau đó cho dầu ăn và một ít đường vào, đảo đều ở lửa nhỏ cho đường tan, chuyển thành màu vàng nâu là được.");
//        dbHandler.addInstruction(1,6,"Sau đó cho hành tím và tỏi vào, phi lên cho thơm, rồi cho thịt heo vào, đảo trong 5 phút để thịt ngấm gia vị và đều màu.");
//        dbHandler.addInstruction(1,7,"Tiếp đó cho nước vào sâm sấp mặt thịt, kho ở lửa vừa cho thịt chín mềm, nước kho sệt lại theo ý thích thì tắt bếp.");
//        dbHandler.addInstruction(1,8,"Rắc lên một ít tiêu, hành lá và ớt, vậy là món thịt kho tộ đã xong rồi đó, cho ra bàn ăn và thưởng thức ngay thôi.");
//        dbHandler.addInstruction(2,1,"Lấy khoảng 3 nhánh tiêu, lượng tiêu tương đương với 1 muỗng canh tiêu xanh. Gỡ hết tất cả hạt tiêu xanh ra khỏi cuống và giã dập.");
//        dbHandler.addInstruction(2,2,"Hành lá cắt khúc vừa ăn. Tỏi băm nhỏ. Ớt cắt thành khoanh vừa ăn.");
//        dbHandler.addInstruction(2,3,"Để khử mùi hôi, thịt gà mua về nhổ lông cho sạch. Trộn 1 ít giấm và muối rồi xoa đều lên khắp phần thịt gà rồi rửa lại bằng nước sạch.");
//        dbHandler.addInstruction(2,4,"Cắt thành những miếng vuông vừa ăn có kích thước cỡ 1 đốt ngón tay, để ráo.");
//        dbHandler.addInstruction(2,5,"Ướp thịt gà với 1/2 muỗng cà phê muối, 1/2 muỗng cà phê bột ngọt, 1/2 muỗng cà phê hạt nêm, 2 muỗng cà phê đường, 3 muỗng canh nước mắm, 1 muỗng canh nước màu, 1 muỗng canh tiêu hạt giã dập.");
//        dbHandler.addInstruction(2,6,"Trộn đều và để khoảng 20 - 30 phút để thịt gà ngấm đều gia vị.");
//        dbHandler.addInstruction(2,7,"Bắc 1 cái chảo lên bếp. Cho vào 2 muỗng canh dầu ăn. Khi dầu nóng thì cho phần tỏi băm vào phi thơm, cho đến khi tỏi bắt đầu chuyển màu vàng.");
//        dbHandler.addInstruction(2,8,"Lúc này, bạn cho gà vào xào trong khoảng 5 phút để gà bắt đầu săn lại và chín.");
//        dbHandler.addInstruction(2,9,"Tiếp theo, bạn cho nửa chén nước vào, hạ lửa nhỏ, tiếp tục kho đến khi nước kho bắt đầu sệt lại.");
//        dbHandler.addInstruction(2,10,"Tiếp theo, bạn cho 5 nhánh tiêu xanh và ớt cắt khoanh vào kho khoảng 2 - 3 phút là gà chín, rắc hành lá lên rồi tắt bếp.");
//        dbHandler.addInstruction(2,11,"Món gà kho tiêu vàng óng đẹp mắt, thịt gà thơm phức quyện cùng vị cay nồng của tiêu xanh là một lựa chọn hoàn hảo cho những ngày mưa lạnh đấy!");
//        dbHandler.addInstruction(3,1,"Bạn ngâm thịt bò trong nước muối loãng tầm 10 phút, sau đó vớt thịt ra, rửa lại thêm 2 - 3 lần nước nữa rồi dùng khăn sạch thấm khô thịt bò.");
//        dbHandler.addInstruction(3,2,"Khi thịt đã ráo nước, bạn cắt thịt thành từng lát dài có độ dày 3cm rồi tiếp tục thái nhỏ thịt thành từng miếng vuông vừa ăn.");
//        dbHandler.addInstruction(3,3,"Bạn cho vào chảo 20ml dầu ăn, khi dầu nóng, bạn cho toàn bộ hành tím, tỏi, ớt và sả đã được băm nhuyễn vào và phi thơm.");
//        dbHandler.addInstruction(3,4,"Khi các nguyên liệu đã vàng, bạn cho 50gr sốt tiêu, 50gr tương ớt, 60ml nước cùng 5gr hạt nêm vào khuấy đều trên lửa vừa cho đến khi hỗn hợp sánh lại.");
//        dbHandler.addInstruction(3,5,"Khi nước sốt đã có độ sệt hoàn hảo, bạn cho thịt bò vào và đảo đều để thịt săn lại. Tiếp đến, bạn cho 30gr hạt tiêu xanh vào, dùng vá trộn đều để các nguyên liệu hòa quyện vào nhau.");
//        dbHandler.addInstruction(3,6,"Cuối cùng, bạn đậy nắp, rim thịt bò trên lửa vừa trong 15 phút cho đến khi thịt bò chín mềm là được.");
//        dbHandler.addInstruction(3,7,"Thịt vai bò với phần nạc mềm, có thêm chút gân sần sật, lại đậm đà, thấm vị, kết hợp với tiêu xanh thơm lừng, có chút ớt hiểm cay cay ăn cùng với cơm nóng quả thật là không thể chê vào đâu được.");
//        dbHandler.addInstruction(4,1,"Khử bớt mùi tanh của cá bằng cách làm sạch. Rửa cá với hỗn hợp nước muối loãng pha thêm một chút giấm và gừng băm nhỏ, sau đó rửa sạch lại dưới vòi nước và để ráo.");
//        dbHandler.addInstruction(4,2,"Cắt cá thành từng khúc nhỏ.");
//        dbHandler.addInstruction(4,3,"Thịt lợn rửa sạch, để ráo nước, thái thành từng miếng nhỏ vừa ăn.");
//        dbHandler.addInstruction(4,4,"Hành khô bóc vỏ, rửa sạch. Chia 2 nửa, 1 nửa băm nhỏ, 1 nửa cắt đôi.");
//        dbHandler.addInstruction(4,5,"Tỏi bóc vỏ, rửa sạch, băm nhỏ");
//        dbHandler.addInstruction(4,6,"Bắc nồi lên bếp, cho một chút dầu ăn cùng hành khô băm và tỏi băm vào phi vàng, dậy mùi thơm.");
//        dbHandler.addInstruction(4,7,"Cho thịt lợn ba chỉ vào đảo đều đến khi thịt săn lại. Sau đó xếp cá vào nồi, thêm hành khô cắt miếng và hành lá. Ở bước này, nếu muốn ăn cay bạn có thể cho thêm ớt tươi, hạt tiêu vào kho cùng.");
//        dbHandler.addInstruction(4,8,"Cho nước dừa vào nồi, kho lửa nhỏ trong khoảng 20 phút. Nếu không muốn dùng nước dừa, bạn có thể thay bằng nước thường. Đun đến khi nước trong nồi gần cạn, hơi keo lại, thịt cá có màu vàng nâu đẹp mắt, phần mỡ ở thịt lợn trở nên trong.");

        monAnMienBac();
        monAnMienTrung();
        monAnMienNam();
        slider();
    }

    private void monAnMienNam() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        listMonAnMienNam = findViewById(R.id.view3);
        listMonAnMienNam.setLayoutManager(linearLayoutManager);

        ArrayList<Recipe> recipeList = new ArrayList<>();
//        recipeList.add(new Recipe(1,"Ga xao xa ot","dessert_orange_food_chocolate"));
        DBHandler dbHandler = new DBHandler(this);
        recipeList = dbHandler.listRecipebyCat(3);
        adapter = new RecipeAdapter(this,recipeList);
        listMonAnMienNam.setAdapter(adapter);
    }

    private void monAnMienTrung() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        listMonAnMienTrung = findViewById(R.id.view2);
        listMonAnMienTrung.setLayoutManager(linearLayoutManager);

        ArrayList<Recipe> recipeList = new ArrayList<>();
//        recipeList.add(new Recipe(1,"Ga xao xa ot","dessert_orange_food_chocolate"));
        DBHandler dbHandler = new DBHandler(this);
        recipeList = dbHandler.listRecipebyCat(2);
        adapter = new RecipeAdapter(this,recipeList);
        listMonAnMienTrung.setAdapter(adapter);
    }

    private void slider() {
        viewPager2 = findViewById(R.id.view_pager_2);
        circleIndicator3 = findViewById(R.id.circle_indicator);
        List<Recipe> list = new ArrayList<>();
        DBHandler dbHandler = new DBHandler(this);
        list = dbHandler.getSlider();
        SliderAdapter sliderAdapter = new SliderAdapter(this, list);
        viewPager2.setAdapter(sliderAdapter);
        circleIndicator3.setViewPager(viewPager2);
    }

    private void monAnMienBac() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        listMonAnMienBac = findViewById(R.id.view1);
        listMonAnMienBac.setLayoutManager(linearLayoutManager);

        ArrayList<Recipe> recipeList = new ArrayList<>();
//        recipeList.add(new Recipe(1,"Ga xao xa ot","dessert_orange_food_chocolate"));
        DBHandler dbHandler = new DBHandler(this);
        recipeList = dbHandler.listRecipebyCat(1);
        adapter = new RecipeAdapter(this,recipeList);
        listMonAnMienBac.setAdapter(adapter);
    }

}