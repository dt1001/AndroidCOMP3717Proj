package comp3717.bcit.ca.projectapp;

public class Recipe {

    private String title;
    private byte[] imgBlob;
    private String category;
    private String cookingTime;
    private String ingredients;
    private String procedure;

    public Recipe() {

    }

    public Recipe(String title, byte[] imgBlob, String category, String cookingTime, String ingredients, String procedure) {
        //this.recipe_id = recipe_id;
        this.title = title;
        this.imgBlob = imgBlob;
        this.category = category;
        this.cookingTime = cookingTime;
        this.ingredients = ingredients;
        this.procedure = procedure;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setImageBlob(byte []imgBlob) {
        this.imgBlob = imgBlob;
    }

    public byte[] getImageBlob() {
        return this.imgBlob;
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
public class Recipe {
    private String name;
    private int imageResourceId;
    private String category;
    private String cookingTime;
    private String description;

    // Sample recipes. Additional items will be added to this list
    public static final Recipe[] recipeList = {
        new Recipe("Pumpkin Soup", R.drawable.pumpkinsoup, "Soup", "10min", "Yummy Pumpkin Soup colour is yellow."),
        new Recipe("Tomato Soup", R.drawable.tomatosoup, "Soup", "10min", "Yum Yum Tomato Soup. Good for cold."),
        new Recipe("Caesar Salad", R.drawable.caesarsalad, "Salad", "5min", "Historical salad"),
        new Recipe("Potato Salad", R.drawable.potatosalad, "Salad", "10min", "This salad has a sad history.")
    };

    private Recipe(String name, int imageResourceId, String category, String cookingTime, String description) {
        this.name = name;
        this.imageResourceId = imageResourceId;
        this.category = category;
        this.cookingTime = cookingTime;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getCategory() {
        return category;
    }

    public String getCookingTime() {
        return cookingTime;
    }

    public String getDescription() {
        return description;
    }
}*/

