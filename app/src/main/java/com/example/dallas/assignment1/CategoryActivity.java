package com.example.dallas.assignment1;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
//import com.example.dallas.recipe.*;

/**
 * Lists all the recipes in the chosen category
 */
public class CategoryActivity extends ListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        //get recipes from database
        Bundle extras = getIntent().getExtras();
        String category = (String)extras.get("CATEGORY");
        //TextView category_name = (TextView)findViewById(R.id.category_title);
        //category_name.setText("Category("+category+"):");
        getRecipes(category);//get recipes from database
    }

    /**
     * listener for clicking an item on the ListView
     * @param list
     * @param view
     * @param position
     * @param id
     */
    protected void onListItemClick(ListView list, View view, int position, long id){
        super.onListItemClick(list,view,position,id);
        String recipe = ( (String)( getListView().getItemAtPosition(position)) );
    }

    /**
     * gets all the recipes from the specified category
     * from the database, creates a recipe object for each
     * entry and puts all objects into the recipes LinkedList
     * @param category
     */
    private void getRecipes(String category){
        //gets all recipes from database
        ArrayList<String> test = new ArrayList<>();//replace test with sql
        test.add("chick");
        test.add("mystery chicken");
        test.add("super chicken");
        test.add("chicken licken");
        //get adapters
        ArrayAdapter<String> adapters = new ArrayAdapter<String>(this, R.layout.activity_category,R.id.txt_view,test);
        setListAdapter(adapters);//set array adapters
    }

}
