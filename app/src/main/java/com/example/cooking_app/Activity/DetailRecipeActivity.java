package com.example.cooking_app.Activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cooking_app.Adapter.IngredientAdapter;
import com.example.cooking_app.Adapter.InstructionAdapter;
import com.example.cooking_app.Model.Ingredient;
import com.example.cooking_app.Model.Instruction;
import com.example.cooking_app.Model.Recipe;
import com.example.cooking_app.R;

import java.util.ArrayList;

public class DetailRecipeActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private RecyclerView listIngredient;
    private RecyclerView listInstruction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
//        Bundle bundle = getIntent().getExtras();
//        if(bundle == null){
//            return;
//        }
//        Recipe recipe = (Recipe) bundle.get("object_recipe");
//        TextView recipeName = findViewById(R.id.textView);
//        ImageView recipeImage = findViewById(R.id.imageView);
//        recipeName.setText(recipe.getNameRecipe());
//        recipeImage.setImageResource(recipe.getImage());
        NguyenLieu();
        CongThuc();
    }

    private void CongThuc() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        listInstruction = findViewById(R.id.list_instruction);
        listInstruction.setLayoutManager(linearLayoutManager);
        ArrayList<Instruction> instructionList = new ArrayList<>();
        instructionList.add(new Instruction(1, "Hành khô các bạn bóc vỏ sau đó rửa sạch rồi băm nhỏ"));
        instructionList.add(new Instruction(3, "Không biết"));
        instructionList.add(new Instruction(4, "Không biết"));
        instructionList.add(new Instruction(5, "Không biết"));
        instructionList.add(new Instruction(6, "Không biết"));
        instructionList.add(new Instruction(7, "Không biết"));
        instructionList.add(new Instruction(2, "Mộc nhĩ ngâm vào nước để nở rồi rửa sạch sau đó cắt nhỏ"));
        for(int i=0;i<instructionList.size()-1;i++){
            for(int j=i+1;j<instructionList.size();j++){
                if(instructionList.get(i).getStep() > instructionList.get(j).getStep()){
                    Instruction temp = instructionList.get(i);
                    instructionList.set(i, instructionList.get(j));
                    instructionList.set(j, temp);
                }
            }
        }
        adapter = new InstructionAdapter(this, instructionList);
        listInstruction.setAdapter(adapter);

    }

    private void NguyenLieu() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        listIngredient = findViewById(R.id.list_ingredient);
        listIngredient.setLayoutManager(linearLayoutManager);
        ArrayList<Ingredient> ingredientList = new ArrayList<>();
        ingredientList.add(new Ingredient("thịt heo xay hoặc băm","200g"));
        ingredientList.add(new Ingredient("đậu phụ chiên","100g"));
        ingredientList.add(new Ingredient("hành",""));
        ingredientList.add(new Ingredient("gừng",""));
        ingredientList.add(new Ingredient("nước tương","45ml"));
        ingredientList.add(new Ingredient("hạt nêm",""));
        ingredientList.add(new Ingredient("đường",""));
        ingredientList.add(new Ingredient("bột bắp","1 thìa cafe"));
        adapter = new IngredientAdapter(ingredientList,this);
        listIngredient.setAdapter(adapter);
    }
}
