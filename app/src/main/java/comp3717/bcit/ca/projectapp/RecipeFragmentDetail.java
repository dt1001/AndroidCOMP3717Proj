package comp3717.bcit.ca.projectapp;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class RecipeFragmentDetail extends Activity {

    public static final String EXTRA_RecipeNo = "recipeNo";
    public static final String EXTRA_RecipeTitle = "recipeName";
    private RecipeDbHelper dbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_recipe_detail);
        dbhelper = new RecipeDbHelper(this);

        // Get index from the recipe list
        String recipeTitle = getIntent().getStringExtra(EXTRA_RecipeTitle);
        Recipe recipe = dbhelper.getRecipeByTitle(recipeTitle);

        // Get selected recipe image
        byte [] recipeImage = recipe.getImageBlob();
        ImageView imageView = (ImageView)findViewById(R.id.recipe_image);
        Bitmap bitmap = BitmapFactory.decodeByteArray(recipeImage,0,recipeImage.length);
        imageView.setImageBitmap(bitmap);

        // Get selected recipe name
        TextView textViewName = (TextView)findViewById(R.id.recipe_title);
        textViewName.setText(recipeTitle);
        // Set recipe name as a caption
        imageView.setContentDescription(recipeTitle);

        // Get selected recipe category
        String recipeCategory = recipe.getCategory();
        TextView textViewCategory = (TextView)findViewById(R.id.recipe_category);
        textViewCategory.setText(recipeCategory);

        // Get selected recipe cooking time
        String recipeCookingTime = recipe.getCookingTime();
        TextView textViewCookingTime = (TextView)findViewById(R.id.recipe_cooking_time);
        textViewCookingTime.setText(recipeCookingTime);

        // Get selected recipe ingredients
        String recipeIngredients = recipe.getIngredients();
        TextView textViewIngredients = (TextView)findViewById(R.id.recipe_ingredients);
        textViewIngredients.setText(recipeIngredients);

        // Get selected recipe instructions
        String recipeDesc = recipe.getProcedure();
        TextView textViewDesc = (TextView)findViewById(R.id.recipe_description);
        textViewDesc.setText(recipeDesc);
    }
}
