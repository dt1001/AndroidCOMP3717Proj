package comp3717.bcit.ca.projectapp;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class RecipeFragmentDetail extends Activity {

    public static final String EXTRA_RecipeNo = "recipeNo";
    public static final String EXTRA_RecipeTitle = "recipeTitle";
    private RecipeDbHelper dbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_recipe_detail);
        dbhelper = new RecipeDbHelper(this);

        // Get index from the recipe list
        String recipeTitle = getIntent().getStringExtra(EXTRA_RecipeTitle);
        Log.d("Recipe Title",recipeTitle);
        Recipe recipe = dbhelper.getRecipeByTitle(recipeTitle);
        // Get selected recipe image
        String recipeImage = recipe.getImagePath();
        ImageView imageView = (ImageView) findViewById(R.id.recipe_image);
        if(recipeImage!=null && !recipeImage.equals("")) {
            imageView.setImageBitmap(BitmapFactory.decodeFile(recipeImage));
        }
        else{//set default image
            Drawable myDrawable = this.getResources().getDrawable(R.drawable.potatosalad);
            imageView.setImageDrawable(myDrawable);
        }

        // Get selected recipe name
        TextView textViewName = (TextView)findViewById(R.id.recipe_title);
        textViewName.setText(recipeTitle);
        // Set recipe name as a caption
        imageView.setContentDescription(recipeTitle);

        // Get selected recipe category
        String recipeCategory = recipe.getCategory();
        TextView textViewCategory = (TextView)findViewById(R.id.recipe_category);
        if(recipeCategory!=null) {
            textViewCategory.setText(recipeCategory);
        }

        // Get selected recipe cooking time
        String recipeCookingTime = recipe.getCookingTime();
        TextView textViewCookingTime = (TextView)findViewById(R.id.recipe_cooking_time);
        if(recipeCookingTime!=null) {
            textViewCookingTime.setText(recipeCookingTime);
        }

        // Get selected recipe ingredients
        String recipeIngredients = recipe.getIngredients();
        TextView textViewIngredients = (TextView)findViewById(R.id.recipe_ingredients);
        if(recipeIngredients!=null) {
            textViewIngredients.setText(recipeIngredients);
        }

        // Get selected recipe instructions
        String recipeDesc = recipe.getProcedure();
        TextView textViewDesc = (TextView)findViewById(R.id.recipe_description);
        if(recipeDesc!=null) {
            textViewDesc.setText(recipeDesc);
        }
    }
}
