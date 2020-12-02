package fi.metropolia.easytocook.receipe;

import java.util.ArrayList;
import java.util.List;

public class Cuisine {

    private static final Cuisine cuisineInstance = new Cuisine();

    public static Cuisine getInstance(){
        return cuisineInstance;
    }

    private List<Dish> dishes;

    private Cuisine (){
        this.dishes = new ArrayList<>();
    }

    public void setAllDishes (List<Dish> allDishes){
        this.dishes = allDishes;
    }

    public List<Dish> getAllDishes(){
        return this.dishes;
    }
    public Dish getDish(int indexOfADish){
        return this.dishes.get(indexOfADish);
    }
    public void addDish(Dish dish){
        this.dishes.add(dish);
    }

}
