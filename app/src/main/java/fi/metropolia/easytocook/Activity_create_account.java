package fi.metropolia.easytocook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import fi.metropolia.easytocook.userProfile.User;
import fi.metropolia.easytocook.userProfile.UserAccount;

public class Activity_create_account extends AppCompatActivity {
    public static final String TAG = "myApp";
    public static SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        Log.d(TAG, "on Created");
        sharedPreferences = getSharedPreferences("myApp_shadPrefer", Context.MODE_PRIVATE);

        findViewById(R.id.btn_create_account).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //read input values
                //User
                // User user = new User (fname, ...)
                //UserAccount singleton
                //UserAccount.getUserAccountInstance.add(new User())
                Intent intentUserProfile = new Intent(getApplicationContext(), Activity_userProfile.class);
                startActivity(intentUserProfile);

            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "on Pause");

        EditText firstName = findViewById(R.id.first_name);
        EditText lastName = findViewById(R.id.last_name);
        EditText email = findViewById(R.id.EmailAddress);
        EditText userName = findViewById(R.id.username);
        EditText password = findViewById(R.id.Password);
        EditText verifiedPassword = findViewById(R.id.verify_password);

        String fNameInput = firstName.getText().toString();
        Log.i(TAG, fNameInput);
        String lastNameInput = lastName.getText().toString();
        Log.i(TAG, lastNameInput);
        String emailInput = email.getText().toString();
        Log.i(TAG, emailInput);
        String userNameInput = userName.getText().toString();
        Log.i(TAG, userNameInput);
        String passwordInput = password.getText().toString();
        Log.i(TAG, passwordInput);
        String verifiedPasswordInput = verifiedPassword.getText().toString();
        //checkPass();


        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("firstName", fNameInput);
        editor.putString("lastName", lastNameInput);
        editor.putString("email", emailInput);
        editor.putString("userName", userNameInput);
        editor.putString("password", passwordInput);
        editor.apply();

        UserAccount userAccount = UserAccount.getInstance();
        userAccount.addUser(new User(fNameInput, lastNameInput, emailInput, userNameInput, passwordInput));
        Log.d(TAG, userAccount.getUser(0).toString());

    }


    /*private void checkPass(){
        EditText verifiedPassword = findViewById(R.id.verify_password);
        EditText password = findViewById(R.id.Password);
        String passwordInput = password.getText().toString();
        String verifiedPasswordInput = verifiedPassword.getText().toString();

        if(passwordInput.equals(verifiedPasswordInput)){
            findViewById(R.id.verify_password).setText();
        }*/
}




