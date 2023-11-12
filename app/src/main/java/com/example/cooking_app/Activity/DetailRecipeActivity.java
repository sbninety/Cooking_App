package com.example.cooking_app.Activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.cooking_app.Adapter.IngredientAdapter;
import com.example.cooking_app.Adapter.InstructionAdapter;
import com.example.cooking_app.Database.DBHandler;
import com.example.cooking_app.Model.Ingredient;
import com.example.cooking_app.Model.IngredientDetail;
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
        Bundle bundle = getIntent().getExtras();
        if(bundle == null){
            return;
        }
        Recipe recipe = (Recipe) bundle.get("object_recipe");
        TextView recipeName1 = findViewById(R.id.name1);
        recipeName1.setText(recipe.getNameRecipe());
        TextView recipeName2 = findViewById(R.id.name2);
        recipeName2.setText(recipe.getNameRecipe());
        TextView time = findViewById(R.id.time);
        time.setText(recipe.getTimeRecipe());
        TextView people = findViewById(R.id.people);
        people.setText(recipe.getPeopleRecipe() + " người");
        ImageView imageRecipe = findViewById(R.id.imageRecipe);
        int drawableReourceId = getResources().getIdentifier(recipe.getImageRecipe(),"drawable",getPackageName());
        Glide.with(this).load(drawableReourceId).into(imageRecipe);
        NguyenLieu(recipe);
        CongThuc(recipe);
    }

    private void CongThuc(Recipe recipe) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        listInstruction = findViewById(R.id.list_instruction);
        listInstruction.setLayoutManager(linearLayoutManager);
        ArrayList<Instruction> instructionList = new ArrayList<>();
        DBHandler dbHandler = new DBHandler(this);
        instructionList = dbHandler.getAllInstruction(recipe.getId());
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

    private void NguyenLieu(Recipe recipe) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        listIngredient = findViewById(R.id.list_ingredient);
        listIngredient.setLayoutManager(linearLayoutManager);
        ArrayList<IngredientDetail> ingredientDetails = new ArrayList<>();
        DBHandler dbHandler = new DBHandler(this);
        ingredientDetails = dbHandler.getAllRecipeIngre(recipe.getId());
        adapter = new IngredientAdapter(ingredientDetails,this);
        listIngredient.setAdapter(adapter);
    }
}
