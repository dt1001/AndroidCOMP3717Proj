package com.example.dallas.assignment1;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Allows the user to select the category of recipes they wish to view
 */
public class SelectCategoryActivity extends ListActivity {
    private LinkedList<String> categories = new LinkedList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_category);
        populateCategories();
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
        String category = ( (String)getListView().getItemAtPosition(position) );
        Intent intent = new Intent(SelectCategoryActivity.this,CategoryActivity.class);
        intent.putExtra("CATEGORY",category);
        startActivity(intent);
    }
    /**
     * Populates the categories LinkedList with
     * Strings of the names of all categories
     * that are extracted from the database
     */
    private void populateCategories(){
        //gets all recipes from database
        ArrayList<String> test = new ArrayList<>();//replace test with sql
        test.add("Chinese");
        test.add("Western");
        test.add("Italian");
        test.add("Japanese");
        //get adapters
        ArrayAdapter<String> adapters = new ArrayAdapter<String>(this, R.layout.activity_select_category,R.id.txtview,test);
        setListAdapter(adapters);//set array adapters
    }
}
