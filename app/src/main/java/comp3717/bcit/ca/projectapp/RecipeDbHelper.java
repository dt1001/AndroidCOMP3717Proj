package comp3717.bcit.ca.projectapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DallasTang on 10/22/2016.
 */

public class RecipeDbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "recipe.db";
    private static final String TABLE_RECIPE = "recipe";
    private static final String RECIPE_ID = "_id";
    private static final String RECIPE_TITLE = "title";
    private static final String RECIPE_IMAGE_BLOB = "img_blob";
    private static final String RECIPE_CATEGORY = "category";
    private static final String RECIPE_COOKING_TIME = "cooking_time";
    private static final String RECIPE_INGREDIENTS = "ingredients";
    private static final String RECIPE_PROCEDURE = "procedure";

    public RecipeDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * Creates the database on first run
     * @param db
     */
    public void onCreate(SQLiteDatabase db){
        final String CREATE_RECIPE_TABLE =
                "CREATE TABLE IF NOT EXISTS " + TABLE_RECIPE + " ( " +
                        RECIPE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        RECIPE_TITLE + " TEXT NOT NULL, " +
                        RECIPE_IMAGE_BLOB + " BLOB NOT NULL, " +
                        RECIPE_CATEGORY + " TEXT NOT NULL, " +
                        RECIPE_COOKING_TIME + " TEXT NOT NULL, " +
                        RECIPE_INGREDIENTS + " MEMO, " +
                        RECIPE_PROCEDURE + " MEMO)";
        db.execSQL(CREATE_RECIPE_TABLE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVerson) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RECIPE);
        onCreate(db);
    }

    public void createTable() {
        SQLiteDatabase db = this.getWritableDatabase();
        final String CREATE_RECIPE_TABLE =
                "CREATE TABLE IF NOT EXISTS " + TABLE_RECIPE + " ( " +
                        RECIPE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        RECIPE_TITLE + " TEXT NOT NULL, " +
                        RECIPE_IMAGE_BLOB + " BLOB NOT NULL, " +
                        RECIPE_CATEGORY + " TEXT NOT NULL, " +
                        RECIPE_COOKING_TIME + " INTEGER NOT NULL, " +
                        RECIPE_INGREDIENTS + " TEXT NOT NULL, " +
                        RECIPE_PROCEDURE + " TEXT NOT NULL)";
        db.execSQL(CREATE_RECIPE_TABLE);
    }

    public void dropTable() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RECIPE);
    }

    /**
     * Adds recipe object to the database
     * @param recipe
     */
    void addRecipe(Recipe recipe) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(RECIPE_TITLE, recipe.getTitle());
        values.put(RECIPE_IMAGE_BLOB, recipe.getImageBlob());
        values.put(RECIPE_CATEGORY, recipe.getCategory());
        values.put(RECIPE_COOKING_TIME, recipe.getCookingTime());
        values.put(RECIPE_INGREDIENTS, recipe.getIngredients());
        values.put(RECIPE_PROCEDURE, recipe.getProcedure());
        db.insert(TABLE_RECIPE, null, values);
    }

    /**
     * Addes recipe with given parameters to the database
     * @param title
     * @param imgBlob
     * @param category
     * @param cookingTime
     * @param ingredients
     * @param procedure
     */
    void addRecipe(String title, byte[] imgBlob, String category, int cookingTime, String ingredients, String procedure) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(RECIPE_TITLE, title);
        values.put(RECIPE_IMAGE_BLOB, imgBlob);
        values.put(RECIPE_CATEGORY, category);
        values.put(RECIPE_COOKING_TIME, cookingTime);
        values.put(RECIPE_INGREDIENTS, ingredients);
        values.put(RECIPE_PROCEDURE, procedure);
        db.insert(TABLE_RECIPE, null, values);
    }

    /**
     * gets the given recipe
     * @param recipe_id
     * @return Recipe
     */
    public Recipe getRecipe(int recipe_id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_RECIPE, new String[] { RECIPE_ID,
                        RECIPE_TITLE, RECIPE_IMAGE_BLOB, RECIPE_CATEGORY, RECIPE_COOKING_TIME,
                        RECIPE_INGREDIENTS, RECIPE_PROCEDURE}, RECIPE_ID + "=?",
                new String[] { Integer.toString(recipe_id) }, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        Recipe c = new Recipe(cursor.getString(1), cursor.getBlob(2),
                cursor.getString(3), cursor.getString(4),
                cursor.getString(5), cursor.getString(6));
        return c;
    }

    /**
     * gets the given recipe
     * @param recipe_title
     * @return Recipe
     */
    public Recipe getRecipeByTitle(String recipe_title) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_RECIPE,
                        new String[] {
                                RECIPE_ID, RECIPE_TITLE, RECIPE_IMAGE_BLOB,
                                RECIPE_CATEGORY, RECIPE_COOKING_TIME,
                                RECIPE_INGREDIENTS, RECIPE_PROCEDURE
                        },
                        RECIPE_TITLE + "=?",
                        new String[]{ recipe_title}
                        , null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        Recipe c = new Recipe(cursor.getString(1), cursor.getBlob(2),
                cursor.getString(3), cursor.getString(4),
                cursor.getString(5), cursor.getString(6));
        return c;
    }

    /**
     * Returns the number of recipes in the database
     * @return int
     */
    public int getRecipeCount() {
        String countQuery = "SELECT * FROM " + TABLE_RECIPE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        //cursor.close();
        return cursor.getCount();
    }

    /**
     * Gets all recipes and stores them as a recipe collection
     * @return collection
     */
    public List<Recipe> getAllRecipes() {
        List<Recipe> recipeList = new ArrayList<Recipe>();
        String selectQuery = "SELECT * FROM " + TABLE_RECIPE;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Recipe recipe = new Recipe();
                recipe.setTitle(cursor.getString(1));
                recipe.setImageBlob(cursor.getBlob(2));
                recipe.setCategory(cursor.getString(3));
                recipe.setCookingTime(cursor.getString(4));
                recipe.setIngredients(cursor.getString(5));
                recipe.setProcedure(cursor.getString(6));
                recipeList.add(recipe);
            } while (cursor.moveToNext());
        }
        return recipeList;
    }
}
