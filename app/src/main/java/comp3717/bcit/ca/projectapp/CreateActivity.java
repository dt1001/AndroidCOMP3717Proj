package comp3717.bcit.ca.projectapp;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Used to get parameters from a user to create a new recipe
 */
public class CreateActivity extends Activity {
    private RecipeDbHelper dbhelper;
    private static final int RESULT_LOAD_IMG = 1;
    private String imgDecodableString;
    private byte[] imgByteArr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        dbhelper = new RecipeDbHelper(this);
        //create button onClickListener
        Button add_btn = (Button) findViewById(R.id.add_btn);
        add_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                try {
                    addRecipeToDatabse();
                    //inform user that recipe was added then quick activity
                    Toast.makeText(getApplicationContext(),"Recipe was added!",Toast.LENGTH_SHORT).show();
                    finish();
                }
                catch(SQLException e) {
                    Toast.makeText(getApplicationContext(), "Could not add recipe, one or more fields were invalid", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //cancel button onClickListener
        Button cancel_btn = (Button) findViewById(R.id.cancel_btn);
        cancel_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish();
            }
        });

        //add image onclick listener
        final TextView addImage = (TextView) findViewById(R.id.add_img);
        ImageView recipeImage = (ImageView) findViewById(R.id.recipe_image);
        recipeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addImage.setText("Click to change image");
                loadImagefromGallery(view);
            }
        });
    }

    /**
     * Takes all the fields on the screen and
     * uses them to create a new recipe in
     * the database
     */
    private void addRecipeToDatabse() throws SQLException{
        //text fields on the screen
        final TextView titleView = (TextView) findViewById(R.id.title_edit_txt);
        final TextView categoryView = (TextView) findViewById(R.id.category_edit_txt);
        final TextView cookingTimeView = (TextView) findViewById(R.id.cookingtme_edit_txt);
        final EditText ingredientsView = (EditText) findViewById(R.id.ingredients_txt);
        final EditText instructionsView = (EditText) findViewById(R.id.instructions_txt);
        //get fields from activity
        String title = titleView.getText().toString();
        String category = categoryView.getText().toString();
        int cookingTime = Integer.parseInt(cookingTimeView.getText().toString());
        String ingredients = ingredientsView.getText().toString();
        String instructions = instructionsView.getText().toString();
        //do error checking
        //add to database
        dbhelper.addRecipe(title,imgByteArr,category,cookingTime,ingredients,instructions);
    }

    /**
     * Loads images from gallery
     * @param view
     */
    protected void loadImagefromGallery(View view) {
        // Create intent to Open Image applications like Gallery, Google Photos
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(galleryIntent, RESULT_LOAD_IMG);
    }


    @Override
    /**
     * Gets an image from the user's gallery to use as
     * a recipe image
     */
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            // When an Image is picked
            if ( requestCode == RESULT_LOAD_IMG && resultCode == RESULT_OK && data != null) {
                // Get the Image from data
                Uri selectedImage = data.getData();
                String[] filePathArray = { MediaStore.Images.Media.DATA };
                // Get the cursor
                Cursor cursor = getContentResolver().query(selectedImage, filePathArray, null, null, null);
                // Move to first row
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(filePathArray[0]);
                imgDecodableString = cursor.getString(columnIndex);
                cursor.close();
                ImageView recipeImg = (ImageView) findViewById(R.id.recipe_image);
                // Set the Image in ImageView after decoding the String
                Bitmap bitmap = BitmapFactory.decodeFile(imgDecodableString);//image bitmap
                recipeImg.setImageBitmap(bitmap);
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                imgByteArr = stream.toByteArray();
                stream.close();
            }
            else {
                Toast.makeText(this, "No image was selected",Toast.LENGTH_LONG).show();
            }
        }
        catch(IOException e){
            e.printStackTrace();
            Log.d("Error get image:",e.getMessage());
        }
        catch (Exception e) {
            e.printStackTrace();
            Log.d("Error get image:",e.getMessage());
            Toast.makeText(this, "Could not get the desired image", Toast.LENGTH_LONG).show();
        }
    }
}
