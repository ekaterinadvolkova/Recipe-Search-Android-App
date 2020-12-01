package fi.metropolia.easytocook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Activity_create_account extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        findViewById(R.id.btn_create_account).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //read input values
                //User
                    // User user = new User (fname, ...)
                //UserAccount singleton
                    //UserAccount.getUserAccountInstance.add(new User())
                Intent intentUserProfile = new Intent (getApplicationContext(),Activity_userProfile.class);
                startActivity(intentUserProfile);

            }
        });
    }
}