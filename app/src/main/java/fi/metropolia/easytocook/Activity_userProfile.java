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
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        findViewById(R.id.btnLogOut).setOnClickListener(myClickListener);

        findViewById(R.id.btnCalories).setOnClickListener(myClickListener);

        findViewById(R.id.btnRecipe).setOnClickListener(myClickListener);

        findViewById(R.id.btnTime).setOnClickListener(myClickListener);

    }
}