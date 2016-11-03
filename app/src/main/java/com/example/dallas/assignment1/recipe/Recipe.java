package com.example.dallas.assignment1.recipe;

import java.util.ArrayList;

/**
 * Created by DallasTang on 10/20/2016.
 */

public class Recipe {
    private String title;
    private String category;
    private int cookingTime;
    private ArrayList<Ingredient> ingredients;
    private ArrayList<String> instructions;

    /**
     * default contrsuctor
     */
    public Recipe(){

    }
    public Recipe(String title, String category, int cookingTime){
        if(title != null && !title.equals("")) {
            this.title = title;
        }
        if (category != null && !category.equals("")) {
            this.category = category;
        }
        if(cookingTime >= 0){
            this.cookingTime = cookingTime;
        }
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        if(title != null && !title.equals("")) {
            this.title = title;
        }
    }

    public String getCategory(){
        return category;
    }
    public void setCategory(String category){
        if(category != null && !category.equals("")) {
            this.category = category;
        }
    }

    public int getCookingTime(){
        return cookingTime;
    }
    public void setCookingTime(int cookingTime){
        if(cookingTime >= 0){
            this.cookingTime = cookingTime;
        }
    }

    public void addInstructions(String dir){
        if (dir != null) {
            instructions.add(dir);
        }
    }

    public void addIngredient(String name, int quant){
        if(name != null && quant > 0 ){
            ingredients.add(new Ingredient(name,quant));
        }
    }

    public String[] getInstructions(){
        return (String[]) instructions.toArray();
    }
}
