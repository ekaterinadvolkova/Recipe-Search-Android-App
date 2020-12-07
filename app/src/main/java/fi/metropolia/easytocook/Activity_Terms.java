package fi.metropolia.easytocook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity_Terms extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__terms);

        //make a go back to the main account button
        Button back = findViewById(R.id.btnGoBack);
        back.setOnClickListener(myClickListener);
    }


        protected View.OnClickListener myClickListener = v -> {

            if (v == findViewById(R.id.btnGoBack)) {
                Intent intentCreateRecipe = new Intent(getApplicationContext(), Activity_create_account.class);
                startActivity(intentCreateRecipe);
            }

        };
}