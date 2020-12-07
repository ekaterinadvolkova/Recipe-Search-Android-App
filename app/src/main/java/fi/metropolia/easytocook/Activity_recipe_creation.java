package fi.metropolia.easytocook;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.HashMap;
import java.util.Map;

import static fi.metropolia.easytocook.R.id.dishName;

public class Activity_recipe_creation extends AppCompatActivity {

    //FirebaseFirestore db = FirebaseFirestore.getInstance();
    public static final String TAG = "recipe";
    public EditText ingredient, cookTime, calories, recipe, dish;
    FirebaseFirestore recipeDB = FirebaseFirestore.getInstance();

    //set up UI views
    private void setupUIViews() {
         ingredient = (EditText)findViewById(R.id.ingInput);
         cookTime = (EditText)findViewById(R.id.ckTimeInput);
         calories = (EditText)findViewById(R.id.calorieInput);
         recipe = (EditText)findViewById(R.id.howToCookInput);
         dish = (EditText)findViewById(dishName);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_recipe_creation);
        super.onCreate(savedInstanceState);
        //Button btnrecipe = findViewById(R.id.btnSaveRecipe);

        findViewById(R.id.btnSaveRecipe).setOnClickListener(this::onClick);
    }

    private void onClick(View v) {
        //setupUIViews();

        if (validate()) {
            //add the recipe to the DB
            recipeList();

            //direct the user to the activity recipe_detail
            startActivity(new Intent(Activity_recipe_creation.this, Activity_search_by_dish.class));
        }
    }

    //add recipes to database
    public void recipeList() {

        Object ingr = ingredient.getText().toString();
        Object cTime =cookTime.getText().toString();
        Object cal = calories.getText().toString();
        Object recip = recipe.getText().toString();
        Object dishh = dish.getText().toString();

        // Create a new user with a first and last name
        Map<String, Object> Recipe = new HashMap<>();
        Recipe.put("Dish", dishh );
        Recipe.put("Ingredient", ingr );
        Recipe.put("Cooking Time", cTime);
        Recipe.put("Calories", cal );
        Recipe.put("How to Cook?", recip );

        // Add a new document with a generated ID
        final Task<DocumentReference> documentReferenceTask = recipeDB.collection("recipes")
                .add(Recipe)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });
    }

    //add validation method
    private boolean validate() {

        setupUIViews();
        boolean result = false;

        //declare all the data checked
        String ingredients = ingredient.getText().toString();
        String time = cookTime.getText().toString();
        String calorie = calories.getText().toString();
        String recipeName = recipe.getText().toString();
        String dishName = dish.getText().toString();


        //check if the username is not empty, passowrds match, user conditions are accepted
        if (ingredients.isEmpty() || time.isEmpty() || calorie.isEmpty() || recipeName.isEmpty() || dishName.isEmpty()) {
            Toast.makeText(this, "Please, enter all the details", Toast.LENGTH_SHORT).show();
        } else {
            result = true;
        }
        return result;
    }
}




