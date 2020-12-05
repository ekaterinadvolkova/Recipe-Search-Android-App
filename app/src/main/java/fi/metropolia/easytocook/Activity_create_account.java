package fi.metropolia.easytocook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

import fi.metropolia.easytocook.userProfile.User;
import fi.metropolia.easytocook.userProfile.UserAccount;

public class Activity_create_account extends AppCompatActivity {
    public static final String TAG = "myApp";
    public static SharedPreferences sharedPreferences;

    private EditText first_name, last_name, EmailAddress, Password, userName, verifypassword;
    private Button btn_create_account;
    private FirebaseAuth Authentification;


    //set up UI views
    private void setupUIViews(){
        first_name = (EditText)findViewById(R.id.first_name);
        last_name = (EditText)findViewById(R.id.last_name);
        EmailAddress = (EditText)findViewById(R.id.EmailAddress);
        Password = (EditText)findViewById(R.id.Password);
        userName = (EditText)findViewById(R.id.username);
        verifypassword = (EditText)findViewById(R.id.verify_password);
        CheckBox checkbox = findViewById(R.id.chBTerms);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        setupUIViews();

        // initialize the FirebaseAuth instance.
        Authentification = FirebaseAuth.getInstance();


        Log.d(TAG, "on Created");
        sharedPreferences = getSharedPreferences("myApp_shadPrefer", Context.MODE_PRIVATE);

        findViewById(R.id.btn_create_account).setOnClickListener(new View.OnClickListener() {


            // if  data input is validated -> user account & add user data to the database
            @Override
            public void onClick(View v) {


                //validate user details
                if (validate() == true){
                    //direct to the profile page
                    Intent intentUserProfile = new Intent(getApplicationContext(), Activity_userProfile.class);
                    startActivity(intentUserProfile);

                    //upload data to the database
                    String user_Email = EmailAddress.getText().toString().trim();
                    String password = Password.getText().toString().trim();

                    //push to db
                    Authentification.createUserWithEmailAndPassword(user_Email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Log.d(TAG, "createUserWithEmail:success");
                                Toast.makeText(Activity_create_account.this, "Registration successful", Toast.LENGTH_SHORT).show();
                                //after registration complete direct user to the Activity_login
                                startActivity(new Intent(Activity_create_account.this, Activity_logIn.class));
                            } else {
                                Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                Toast.makeText(Activity_create_account.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                };

                //read input values
                //User
                // User user = new User (fname, ...)
                //UserAccount singleton
                //UserAccount.getUserAccountInstance.add(new User())

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

    /*private void checkPass() {
        EditText verifiedPassword = findViewById(R.id.verify_password);
        EditText password = findViewById(R.id.Password);
        String passwordInput = password.getText().toString();
        String verifiedPasswordInput = verifiedPassword.getText().toString();

        if (passwordInput.equals(verifiedPasswordInput)) {
            findViewById(R.id.verify_password).setText();
        }
    }*/

    //validation function
    private boolean validate(){
        Boolean result = false;

        //declare all the data checked
        String name = userName.getText().toString();
        String password = Password.getText().toString();
        String email = EmailAddress.getText().toString();
        String firstname = first_name.getText().toString();
        String lastname = last_name.getText().toString();
        String verify = verifypassword.getText().toString();
        CheckBox checkbox = findViewById(R.id.chBTerms);


        //check if the username is not empty, passowrds match, user conditions are accepted
        if(name.isEmpty() || password.isEmpty() || email.isEmpty() || firstname.isEmpty() || lastname.isEmpty() ||verify.isEmpty()){
            Toast.makeText(this, "Please, enter all the details", Toast.LENGTH_SHORT).show();
        } else if(!verify.equals(password)){
            Toast.makeText(this, "Please, enter same passwords", Toast.LENGTH_SHORT).show();
        } else if(!checkbox.isChecked()){
            Toast.makeText(this, "Please, agree to the Terms and Privacy Policy", Toast.LENGTH_SHORT).show();
        } else {
            result = true;
        }
        return result;
    }
}




