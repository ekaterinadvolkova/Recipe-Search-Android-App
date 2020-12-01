package fi.metropolia.easytocook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Activity_userProfile extends AppCompatActivity {

    private final View.OnClickListener myClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == findViewById(R.id.btnRecipe)) {
                Intent intentCreateRecipe = new Intent(getApplicationContext(), Activity_recipe_creation.class);
                startActivity(intentCreateRecipe);
            } else if (v == findViewById(R.id.btnLogOut)) {
                Intent intentLogOut = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intentLogOut);
            } else if (v == findViewById(R.id.btnTime)) {
                Intent intentCookingTime = new Intent(getApplicationContext(), Activity_cookingTime.class);
                startActivity(intentCookingTime);
            } else if (v == findViewById(R.id.btnCalories)) {
                Intent intentCalories = new Intent(getApplicationContext(), Activity_calories.class);
                startActivity(intentCalories);
            } else if (v == findViewById(R.id.btnIngredient)){
                Intent intentIngredients = new Intent(getApplicationContext(), Activity_search_by_ingredients.class);
                startActivity(intentIngredients);
            } else if (v == findViewById(R.id.btnCuisine)){
                Intent intentDish = new Intent(getApplicationContext(), Activity_search_by_dish.class);
                startActivity(intentDish);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        //leads back to the main page
        findViewById(R.id.btnLogOut).setOnClickListener(myClickListener);
        //leads to filter by calories
        findViewById(R.id.btnCalories).setOnClickListener(myClickListener);
        //leads to the creation of the recipe
        findViewById(R.id.btnRecipe).setOnClickListener(myClickListener);
        // leads to filtered search based on time
        findViewById(R.id.btnTime).setOnClickListener(myClickListener);
        //leads to filtered search based on ingredients
        findViewById(R.id.btnIngredient).setOnClickListener(myClickListener);
        //leads to filtered normal rearch by dish name
        findViewById(R.id.btnCuisine).setOnClickListener(myClickListener);
    }
}