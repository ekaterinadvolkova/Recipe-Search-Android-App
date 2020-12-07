package fi.metropolia.easytocook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_userProfile extends AppCompatActivity {

    protected View.OnClickListener myClickListener = v -> {

        if (v == findViewById(R.id.btnRecipe)) {
            Intent intentCreateRecipe = new Intent(getApplicationContext(), Activity_recipe_creation.class);
            startActivity(intentCreateRecipe);

        } else if (v == findViewById(R.id.btnLogOut)) {
            Intent intentLogOut = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intentLogOut);

        } else if (v == findViewById(R.id.btnCuisine)){
            Intent intentDish = new Intent(getApplicationContext(), Activity_search_by_dish.class);
            startActivity(intentDish);
        }
    };


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_user_profile);

        Button logOut = findViewById(R.id.btnLogOut);
        Button recipe = findViewById(R.id.btnRecipe);
        Button cuisine =findViewById(R.id.btnCuisine);

        //leads back to the main page
        logOut.setOnClickListener(myClickListener);

        //leads to the creation of the recipe
        recipe.setOnClickListener(myClickListener);

        //leads to filtered normal rearch by dish name
        cuisine.setOnClickListener(myClickListener);
    }
}