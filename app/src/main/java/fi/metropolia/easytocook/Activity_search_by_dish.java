package fi.metropolia.easytocook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.firestore.FirebaseFirestore;

public class Activity_search_by_dish extends AppCompatActivity {
    FirebaseFirestore retrieveDish = FirebaseFirestore.getInstance();

    private final View.OnClickListener myClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v == findViewById(R.id.btnTime)) {
                Intent intentCookTime = new Intent(getApplicationContext(), Activity_cookingTime.class);
                startActivity(intentCookTime);
            } else if (v == findViewById(R.id.btnCalories)) {
                Intent intentCalories = new Intent(getApplicationContext(), Activity_calories.class);
                startActivity(intentCalories);
            } else if (v == findViewById(R.id.btnIngredients)){
                Intent intentIngredients = new Intent(getApplicationContext(), Activity_search_by_ingredients.class);
                startActivity(intentIngredients);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_by_dish);
        //add intent to direct to calories page
        findViewById(R.id.btnTime).setOnClickListener(myClickListener);
        //go to calries filter page
        findViewById(R.id.btnCalories).setOnClickListener(myClickListener);
        //go to ingredients filter page
        findViewById(R.id.btnIngredients).setOnClickListener(myClickListener);
    }
}