package com.example.cooking_app.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.cooking_app.Model.Category;
import com.example.cooking_app.Model.Ingredient;
import com.example.cooking_app.Model.IngredientDetail;
import com.example.cooking_app.Model.Instruction;
import com.example.cooking_app.Model.Recipe;
import com.example.cooking_app.Model.User;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {
    private static final String DB_NAME = "CookingApp";
    private static final int DB_VERSION = 1;
    private static final String TABLE_RECIPE = "recipe";
    private static final String ID_RECIPE = "id";
    private static final String NAME_RECIPE = "name";
    private static final String IMAGE_RECIPE = "image";
    private static final String TIME_RECIPE = "time";
    private static final String PEOPLE_RECIPE = "people";
    private static final String TABLE_CATEGORY = "category";
    private static final String ID_CATEGORY = "id";
    private static final String NAME_CATEGORY = "name";
    private static final String TABLE_RECIPE_CATEGORY = "recipe_category";
    private static final String CATEGORY_ID = "catId";
    private static final String RECIPE_ID = "recipeId";
    private static final String TABLE_INGREDIENT = "ingredient";
    private static final String ID_INGREDIENT = "id";
    private static final String NAME_INGREDIENT = "name";
    private static final String TABLE_RECIPE_INGREDIENT = "recipe_ingredient";
    private static final String REC_ID = "recipeId";
    private static final String INGRE_ID = "ingreId";
    private static final String DECRIPTION_REC_INGRE = "decription";
    private static final String TABLE_INSTRUCTION = "instruction";
    private static final String INSTRUCTION_ID = "id";
    private static final String STEP = "step";
    private static final String DECRIPTION = "decription";
    private static final String RE_ID = "recipeId";
    private static final String TABLE_USER = "user";
    private static final String USER_ID = "id";
    private static final String USER_EMAIL = "email";
    private static final String USER_PASSWORD = "password";
    private static final String USER_NAME = "name";
    private static final String TABLE_WISHLIST = "wishlist";
    private static final String WISHLIST_ID = "idWishList";
    private static final String ID_RE = "idRecipe";
    private static final String ID_USER = "idUser";

    public DBHandler(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query1 = "CREATE TABLE " + TABLE_RECIPE + "("
                + ID_RECIPE + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_RECIPE + " TEXT,"
                + IMAGE_RECIPE + " TEXT,"
                + TIME_RECIPE + " TEXT,"
                + PEOPLE_RECIPE + " TEXT)";
        db.execSQL(query1);
        String query2 = "CREATE TABLE " + TABLE_CATEGORY + "("
                + ID_CATEGORY + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_CATEGORY + " TEXT)";
        db.execSQL(query2);
        String query3 = "CREATE TABLE " + TABLE_RECIPE_CATEGORY + "("
                + CATEGORY_ID + " INTEGER, "
                + RECIPE_ID + " INTEGER)";
        db.execSQL(query3);
        String query4 = "CREATE TABLE " + TABLE_INGREDIENT + "("
                + ID_INGREDIENT + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_INGREDIENT + " TEXT)";
        db.execSQL(query4);
        String query5 = "CREATE TABLE " + TABLE_RECIPE_INGREDIENT + "("
                + REC_ID + " INTEGER, "
                + INGRE_ID + " INTEGER, "
                + DECRIPTION_REC_INGRE + " TEXT)";
        db.execSQL(query5);
        String query6 = "CREATE TABLE " + TABLE_INSTRUCTION + "("
                + INSTRUCTION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + STEP + " INTEGER, "
                + DECRIPTION + " TEXT, "
                + RE_ID + " INTERGER)";
        db.execSQL(query6);
        String query7 = "CREATE TABLE " + TABLE_USER + "("
                + USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + USER_EMAIL + " TEXT, "
                + USER_PASSWORD + " TEXT, "
                + USER_NAME + " TEXT)";
        db.execSQL(query7);
        String query8 = "CREATE TABLE " + TABLE_WISHLIST + "("
                + WISHLIST_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ID_RE + " INTEGER, "
                + ID_USER + " INTEGER)";
        db.execSQL(query8);
    }
    public void addCategory(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME_CATEGORY, name);
        db.insert(TABLE_CATEGORY, null, values);
        db.close();
    }
    public void addRecipe(String name, String image, String time, String people){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME_RECIPE, name);
        values.put(IMAGE_RECIPE, image);
        values.put(TIME_RECIPE, time);
        values.put(PEOPLE_RECIPE, people);
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
    public void addIngredient(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME_INGREDIENT, name);
        db.insert(TABLE_INGREDIENT,null,values);
        db.close();
    }
    public void addRecipeIngredient(int reId, int ingreId, String decription){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(REC_ID, reId);
        values.put(INGRE_ID, ingreId);
        values.put(DECRIPTION_REC_INGRE, decription);
        db.insert(TABLE_RECIPE_INGREDIENT, null, values);
        db.close();
    }
    public void addInstruction(int recipeId, int step, String decription){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(RE_ID, recipeId);
        values.put(STEP, step);
        values.put(DECRIPTION, decription);
        db.insert(TABLE_INSTRUCTION, null, values);
        db.close();
    }

    public void addUser(String email, String password, String name){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(USER_EMAIL, email);
        values.put(USER_PASSWORD, password);
        values.put(USER_NAME, name);
        db.insert(TABLE_USER, null, values);
        db.close();
    }

    public void addWishList(int userId, int recipeId){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ID_RE, recipeId);
        values.put(ID_USER, userId);
        db.insert(TABLE_WISHLIST, null, values);
        db.close();
    }

    public boolean deleteWishList(int userId, int recipeId) {
        SQLiteDatabase db = this.getWritableDatabase();

        String content = ID_RE + " = ? AND " + ID_USER + " = ?";
        String[] value = {String.valueOf(recipeId), String.valueOf(userId)};

        int deletedRows = db.delete(TABLE_WISHLIST, content, value);
        db.close();

        return deletedRows > 0;
    }
    public ArrayList<Recipe> getAllRecipe(){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM " + TABLE_RECIPE;
        Cursor cursor = db.rawQuery(sql, null);
        ArrayList<Recipe> recipeList = new ArrayList<>();
        if(cursor.moveToFirst()){
            do{
                Recipe recipe = new Recipe();
                recipe.setId(cursor.getInt(0));
                recipe.setNameRecipe(cursor.getString(1));
                recipe.setImageRecipe(cursor.getString(2));
                recipe.setTimeRecipe(cursor.getString(3));
                recipe.setPeopleRecipe(cursor.getString(4));
                recipeList.add(recipe);
            }while (cursor.moveToNext());
        }
        return recipeList;
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
                recipe.setTimeRecipe(cursor.getString(3));
                recipe.setPeopleRecipe(cursor.getString(4));
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
                recipe.setTimeRecipe(cursor.getString(3));
                recipe.setPeopleRecipe(cursor.getString(4));
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
    public Category getCategory(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM " + TABLE_CATEGORY + " WHERE " + ID_CATEGORY + " = " + id;
        Cursor cursor = db.rawQuery(sql, null);
        Category category = new Category();
        if(cursor.moveToFirst()){
            do{
                category.setId(cursor.getInt(0));
                category.setName(cursor.getString(1));
            }while (cursor.moveToNext());
        }
        return category;
    }
    public Ingredient getIngredient(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM " + TABLE_INGREDIENT + " WHERE " + ID_INGREDIENT + " = " + id;
        Cursor cursor = db.rawQuery(sql, null);
        Ingredient ingredient = new Ingredient();
        if(cursor.moveToFirst()){
            do{
                ingredient.setId(cursor.getInt(0));
                ingredient.setName(cursor.getString(1));
            }while (cursor.moveToNext());
        }
        return ingredient;
    }
    public ArrayList<IngredientDetail> getAllRecipeIngre(int recipeId){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM " + TABLE_RECIPE_INGREDIENT + " WHERE " + REC_ID + " = " + recipeId;
        Cursor cursor = db.rawQuery(sql, null);
        ArrayList<IngredientDetail> ingredientDetails = new ArrayList<>();
        if(cursor.moveToFirst()){
            do{
                IngredientDetail ingredientDetail = new IngredientDetail();
                ingredientDetail.setIngredient(getIngredient(cursor.getInt(1)));
                ingredientDetail.setDecription(cursor.getString(2));
                ingredientDetails.add(ingredientDetail);
            }while (cursor.moveToNext());
        }
        return ingredientDetails;
    }
    public ArrayList<Instruction> getAllInstruction(int recipeId){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM " + TABLE_INSTRUCTION + " WHERE " + RE_ID + " = " + recipeId;
        Cursor cursor = db.rawQuery(sql, null);
        ArrayList<Instruction> instructions = new ArrayList<>();
        if(cursor.moveToFirst()){
            do {
                Instruction instruction = new Instruction();
                instruction.setId(cursor.getInt(0));
                instruction.setStep(cursor.getInt(1));
                instruction.setDecription(cursor.getString(2));
                instructions.add(instruction);
            }while (cursor.moveToNext());
        }
        return instructions;
    }

    public ArrayList<Recipe> getWishList(int idUser){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM "
                +  TABLE_RECIPE + " INNER JOIN "
                + TABLE_WISHLIST + " ON "
                + ID_RECIPE + " = " + ID_RE
                + " WHERE " + ID_USER + " = " + idUser;
        Cursor cursor = db.rawQuery(sql, null);
        ArrayList<Recipe> recipeList = new ArrayList<>();
        if(cursor.moveToFirst()){
            do{
                Recipe recipe = new Recipe();
                recipe.setId(cursor.getInt(0));
                recipe.setNameRecipe(cursor.getString(1));
                recipe.setImageRecipe(cursor.getString(2));
                recipe.setTimeRecipe(cursor.getString(3));
                recipe.setPeopleRecipe(cursor.getString(4));
                recipeList.add(recipe);
            }while (cursor.moveToNext());
        }
        return recipeList;
    }

    public User getUser(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM " + TABLE_USER + " WHERE " + USER_EMAIL + " = '" + email + "'";
        Cursor cursor = db.rawQuery(sql, null);
        User user = new User();
        if(cursor.moveToFirst()){
            do{
                user.setId(cursor.getInt(0));
                user.setEmail(cursor.getString(1));
                user.setPassword(cursor.getString(2));
                user.setName(cursor.getString(3));
            }while (cursor.moveToNext());
        }
        return user;
    }

    public Boolean CheckEmail(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT * FROM " + TABLE_USER + " WHERE " + USER_EMAIL  + " = '" + email + "' ";
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.getCount() > 0){
            return true;
        }
        else {
            return false;
        }
    }

    public Boolean CheckEmailPassword(String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT * FROM " + TABLE_USER + " WHERE " + USER_EMAIL + " = '" + email + "' AND " + USER_PASSWORD + " = '" + password + "'";
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.getCount() > 0){
            return true;
        }
        else {
            return false;
        }
    }

    public Boolean CheckWish(int userId, int recipeId){
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT * FROM " + TABLE_WISHLIST + " WHERE " + ID_RE + " = '" + recipeId + "' AND " + ID_USER + " = '" + userId + "'";
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.getCount() > 0){
            return true;
        }
        else {
            return false;
        }
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RECIPE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CATEGORY);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RECIPE_CATEGORY);
        onCreate(db);
    }
}
