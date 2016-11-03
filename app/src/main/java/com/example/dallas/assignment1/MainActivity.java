package com.example.dallas.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Main activity for the recipe application.
 * Allows a user to select the option to create
 * a new recipe or view an existing recipe
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //create button onclickListener
        final Button create = (Button)findViewById(R.id.create_btn);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,CreateActivity.class);
                startActivity(intent);
            }
        });

        //view button onClickListener
        final Button view = (Button)findViewById(R.id.view_btn);
        view.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View v){
               Intent intent = new Intent(MainActivity.this, SelectCategoryActivity.class);
               startActivity(intent);
           }
        });

    }
}
