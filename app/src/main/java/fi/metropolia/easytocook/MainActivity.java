package fi.metropolia.easytocook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton btwnWelcome = findViewById(R.id.imgBtnWelcome);

        /* add intent to direct to signUp/Login page */

        btwnWelcome.setOnClickListener(this::onClick);
    }

    public void onClick(View v)
    {
        Intent intentSignUpLogIn = new Intent(getApplicationContext(), Activity_signup_login.class);
        startActivity(intentSignUpLogIn);
    }
}