package fi.metropolia.easytocook.receipe;

public class Dish {
    private Ingredient ingredient;
    private Time time;
    private Calorie calorie;
    private String dishName;
    private String description;

    public Dish (String name, Ingredient ingredient, Time time, Calorie calorie, String description){
        this.dishName = name;
        this.ingredient = ingredient;
        this.time = time;
        this.calorie = calorie;
        this.description = description;
    }

    public String toString(){
        return this.dishName + " "+ this.ingredient + " "+this.time +" "+this.calorie;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public Time getTime() {
        return time;
    }

    public Calorie getCalorie() {
        return calorie;
    }

    public String getDishName() {
        return dishName;
    }
}
