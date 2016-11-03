package com.example.dallas.assignment1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by DallasTang on 10/22/2016.
 */

public class RecipeDbHelper extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Recipe.db";
    //recipes table
    private static final String TABLE_RECIPE = "recipes";
    //recipes column names
    private static final String RECIPE_ID = "recipe_id";
    private static final String RECIPE_TITLE = "title";
    private static final String RECIPE_CATEGORY_ID = "category_id";
    private static final String RECIPE_COOKING_TIME = "cooking_time";
    private static final String RECIPE_INGREDIENT_ID = "ingredient_id";

    //category table
    private static final String TABLE_CATEGORY = "categories";
    //categories column names
    private static final String CATEGORY_ID = "category_id";
    private static final String CATEGORY_NAME = "name";

    //ingredients table
    private static final String TABLE_INGREDIENTS = "ingredients";
    //ingredients column names
    private static final String INGREDIENTS_ID = "ingredient_id";
    private static final String INGREDIENTS_NAME = "name";
    private static final String INGREDIENTS_QUANT = "quantity";
    private static final String INGREDIENTS_QUANT_TYPE = "quantity_type";

    public RecipeDbHelper(Context context){
        super(context,DATABASE_NAME,null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db){
        //create recipe table
        final String CREATE_RECIPE_TABLE =
                "CREATE TABLE IF NOT EXISTS"+TABLE_RECIPE+"("+
                RECIPE_ID + "INTEGER PRIMARY KEY AUTOINCREMENT"+
                RECIPE_TITLE + "TEXT NOT NULL"+
                RECIPE_CATEGORY_ID + "INTEGER FOREIGN KEY"+
                RECIPE_COOKING_TIME + "INTEGER > 0"+
                RECIPE_INGREDIENT_ID + "INTEGER FOREIGN KEY";
        db.execSQL(CREATE_RECIPE_TABLE);
        //create category table
        final String CREATE_CATEGORY_TABLE =
                "CREATE TABLE IF NOT EXISTS" + TABLE_CATEGORY+"("+
                CATEGORY_ID + "INTEGER PRIMARY KEY AUTOINCREMENT"+
                CATEGORY_NAME + "TEXT NOT NULL";
        db.execSQL(CREATE_CATEGORY_TABLE);
        //create ingredients table
        final String CREATE_INGREDIENTS_TABLE =
                "CREATE TABLE IF NOT EXISTS" + TABLE_INGREDIENTS+"("+
                INGREDIENTS_ID + "INTEGER PRIMARY KEY AUTOINCREMENT"+
                INGREDIENTS_NAME + "TEXT NOT NULL"+
                INGREDIENTS_QUANT + "INTEGER >= 0"+
                INGREDIENTS_QUANT_TYPE + "TEXT NOT NULL";
        db.execSQL(CREATE_INGREDIENTS_TABLE);
    }

    public void onUpgrade(SQLiteDatabase db,int oldVersion, int newVerson){
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_RECIPE);
        onCreate(db);
    }
    /*
    public void addRecipe(){}
    public Recipe getRecipe(Recipe recipe){}
    public boolean deleteRecipe(Recipe recipe){}
    public List<Recipe> getAllRecipes(){

    }
    public String getCategory(String category){}
    public List<Category> getAllCategories(){}
    public void cleanCategories(){}
    */
}


