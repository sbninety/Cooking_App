package com.example.cooking_app.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.cooking_app.Model.Category;
import com.example.cooking_app.Model.Recipe;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {
    private static final String DB_NAME = "CookingApp";
    private static final int DB_VERSION = 1;
    private static final String TABLE_RECIPE = "recipe";
    private static final String ID_RECIPE = "id";
    private static final String NAME_RECIPE = "name";
    private static final String IMAGE_RECIPE = "image";
    private static final String TABLE_CATEGORY = "category";
    private static final String ID_CATEGORY = "id";
    private static final String NAME_CATEGORY = "name";
    private static final String TABLE_RECIPE_CATEGORY = "recipe_category";
    private static final String CATEGORY_ID = "catId";
    private static final String RECIPE_ID = "recipeId";
    public DBHandler(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query1 = "CREATE TABLE " + TABLE_RECIPE + "("
                + ID_RECIPE + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_RECIPE + " TEXT,"
                + IMAGE_RECIPE + " TEXT)";
        db.execSQL(query1);
        String query2 = "CREATE TABLE " + TABLE_CATEGORY + "("
                + ID_CATEGORY + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_CATEGORY + " TEXT)";
        db.execSQL(query2);
        String query3 = "CREATE TABLE " + TABLE_RECIPE_CATEGORY + "("
                + CATEGORY_ID + " INTEGER, "
                + RECIPE_ID + " INTEGER)";
        db.execSQL(query3);
    }
    public void addCategory(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME_CATEGORY, name);
        db.insert(TABLE_CATEGORY, null, values);
        db.close();
    }
    public void addRecipe(String name, String image){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME_RECIPE, name);
        values.put(IMAGE_RECIPE, image);
        db.insert(TABLE_RECIPE, null, values);
        db.close();
    }
    public void addRecipeCategory(int catId, int recipeId){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(CATEGORY_ID, catId);
        values.put(RECIPE_ID, recipeId);
        db.insert(TABLE_RECIPE_CATEGORY, null, values);
        db.close();
    }
    public ArrayList<Recipe> listRecipebyCat(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM "
                +  TABLE_RECIPE + " INNER JOIN "
                + TABLE_RECIPE_CATEGORY + " ON "
                + ID_RECIPE + " = " + RECIPE_ID
                + " WHERE " + CATEGORY_ID + " = " + id;
        Cursor cursor = db.rawQuery(sql, null);
        ArrayList<Recipe> recipeList = new ArrayList<>();
        if(cursor.moveToFirst()){
            do{
                Recipe recipe = new Recipe();
                recipe.setId(cursor.getInt(0));
                recipe.setNameRecipe(cursor.getString(1));
                recipe.setImageRecipe(cursor.getString(2));
                recipeList.add(recipe);
            }while (cursor.moveToNext());
        }
        return recipeList;
    }
    public ArrayList<Recipe> getSlider(){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM "
                +  TABLE_RECIPE + " ORDER BY " + ID_RECIPE + " DESC LIMIT 5";
        Cursor cursor = db.rawQuery(sql, null);
        ArrayList<Recipe> recipeList = new ArrayList<>();
        if(cursor.moveToFirst()){
            do{
                Recipe recipe = new Recipe();
                recipe.setId(cursor.getInt(0));
                recipe.setNameRecipe(cursor.getString(1));
                recipe.setImageRecipe(cursor.getString(2));
                recipeList.add(recipe);
            }while (cursor.moveToNext());
        }
        return recipeList;
    }
    public ArrayList<Category> getAllCategory(){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM " + TABLE_CATEGORY;
        Cursor cursor = db.rawQuery(sql, null);
        ArrayList<Category> categoryList = new ArrayList<>();
        if(cursor.moveToFirst()){
            do{
                Category category = new Category();
                category.setId(cursor.getInt(0));
                category.setName(cursor.getString(1));
                categoryList.add(category);
            }while (cursor.moveToNext());
        }
        return categoryList;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RECIPE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CATEGORY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RECIPE_CATEGORY);
        onCreate(db);
    }
}
