package fi.metropolia.easytocook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //add intent to direct to signUp/Login page
        findViewById(R.id.btnWelcome).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSignUpLogIn = new Intent(getApplicationContext(), Activity_signup_login.class);
                startActivity(intentSignUpLogIn);
            }
        });

    }

}