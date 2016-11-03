package com.example.dallas.assignment1;

import android.app.Application;
import android.database.SQLException;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Used to get parameters from a user to create a new recipe
 */
public class CreateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        //create button onClickListener
        Button add_btn = (Button) findViewById(R.id.add_btn);
        add_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                try {
                    addRecipeToDatabse();
                }
                catch(SQLException e) {
                    Toast invalidRecipe = Toast.makeText(getApplicationContext(),"Invalid Recipe",Toast.LENGTH_SHORT);
                    invalidRecipe.show();
                }
                //inform user that recipe was added then quick activity
                Toast success = Toast.makeText(getApplicationContext(),"Recipe was added!",Toast.LENGTH_SHORT);
                finish();
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
        final TextView description = (TextView) findViewById(R.id.desciption_txt);
        //sql to add to database
    }
}
