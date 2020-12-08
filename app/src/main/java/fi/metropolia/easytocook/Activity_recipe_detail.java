package fi.metropolia.easytocook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Activity_recipe_detail extends AppCompatActivity {
    String dish, ingredients, recipe, cookingtime;

    public Activity_recipe_detail(){

    }

    public Activity_recipe_detail(String dish, String ingredients, String recipe, String cookingtime) {
        this.dish = dish;
        this.ingredients = ingredients;
        this.recipe = recipe;
        this.cookingtime = cookingtime;
    }

    public String getDish() {
        return dish;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getRecipe() {
        return recipe;
    }

    public String getCookingtime() {
        return cookingtime;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);
    }
}