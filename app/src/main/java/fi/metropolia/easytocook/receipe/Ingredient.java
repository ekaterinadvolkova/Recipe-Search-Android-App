package fi.metropolia.easytocook.receipe;

import java.util.ArrayList;
import java.util.List;

public class Ingredient {
    private List<Ingredient> ingredients;

    public Ingredient (){
        this.ingredients = new ArrayList<>();
    }

    public void addIngredient(Ingredient ingredient){
        this.ingredients.add(ingredient);
    }
}
