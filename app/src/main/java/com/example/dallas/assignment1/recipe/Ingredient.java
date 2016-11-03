package com.example.dallas.assignment1.recipe;

/**
 * Created by DallasTang on 10/20/2016.
 */

public class Ingredient {
    private String name;
    private int quantity;
    public Ingredient(){
        this.quantity=0;
    }
    public Ingredient(String name, int quantity){
        if(name!=null && !name.equals("")){
            this.name = name;
        }
        if(quantity > 0){
            this.quantity=quantity;
        }
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        if(name!=null && !name.equals("")){
            this.name = name;
        }
    }

    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int quantity){
        if(quantity > 0){
            this.quantity=quantity;
        }
    }
}
