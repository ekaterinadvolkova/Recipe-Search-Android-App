package fi.metropolia.easytocook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

public class Activity_recipe_creation extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_creation);

        EditText ingredient = findViewById(R.id.ingInput);
        EditText cookTime = findViewById(R.id.ckTimeInput);
        EditText calorie = findViewById(R.id.calorieInput);
        EditText description = findViewById(R.id.howToCookInput);

        String ingredientInput = ingredient.getText().toString();
        Log.i(Activity_create_account.TAG,"");
    }
}