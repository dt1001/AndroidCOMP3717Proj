package comp3717.bcit.ca.projectapp;

public class Recipe {

    private String title;
    private String imgPath;
    private String category;
    private String cookingTime;
    private String ingredients;
    private String procedure;

    /**
     * default ctor
     */
    public Recipe(){

    }

    /**
     * ctor for Recipe
     * @param title
     * @param imgPath
     * @param category
     * @param cookingTime
     * @param ingredients
     * @param procedure
     */
    public Recipe(String title, String imgPath, String category, String cookingTime, String ingredients, String procedure) {
        //this.recipe_id = recipe_id;
        this.title = title;
        this.imgPath = imgPath;
        this.category = category;
        this.cookingTime = cookingTime;
        this.ingredients = ingredients;
        this.procedure = procedure;
    }

    //getters and setters
    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setImagePath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getImagePath() {
        return this.imgPath;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCookingTime(String cookingTime) {
        this.cookingTime = cookingTime;
    }

    public String getCookingTime() {
        return this.cookingTime;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public String getProcedure() {
        return this.procedure;
    }

}

/*
    // Sample recipes. Additional items will be added to this list
    public static final Recipe[] recipeList = {
        new Recipe("Pumpkin Soup", R.drawable.pumpkinsoup, "Soup", "10min", "Yummy Pumpkin Soup colour is yellow."),
        new Recipe("Tomato Soup", R.drawable.tomatosoup, "Soup", "10min", "Yum Yum Tomato Soup. Good for cold."),
        new Recipe("Caesar Salad", R.drawable.caesarsalad, "Salad", "5min", "Historical salad"),
        new Recipe("Potato Salad", R.drawable.potatosalad, "Salad", "10min", "This salad has a sad history.")
    };
*/


