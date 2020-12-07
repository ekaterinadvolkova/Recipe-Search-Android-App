package fi.metropolia.easytocook;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

import fi.metropolia.easytocook.userProfile.User;
import fi.metropolia.easytocook.userProfile.UserAccount;

public class Activity_create_account extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    public static final String TAG = "myApp";
    public static SharedPreferences sharedPreferences;
    public EditText first_name, last_name, EmailAddress, Password, userName, verify;
    private FirebaseAuth Authentification;
    private String userID;

    //set up UI views
    private void setupUIViews(){
        first_name = (EditText)findViewById(R.id.first_name);
        last_name = (EditText)findViewById(R.id.last_name);
        EmailAddress = (EditText)findViewById(R.id.EmailAddress);
        Password = (EditText)findViewById(R.id.Password);
        userName = (EditText)findViewById(R.id.username);
        verify =(EditText)findViewById(R.id.verify_password);
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
                if (validate()){

                    //upload data to the database
                    String user_Email = EmailAddress.getText().toString().trim();
                    String password = Password.getText().toString().trim();
                    first_name.getText().toString();
                    last_name.getText().toString();
                    EmailAddress.getText().toString();
                    Password.getText().toString();
                    userName.getText().toString();
                    verify.getText().toString();

                    //push to db
                    Authentification.createUserWithEmailAndPassword(user_Email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Log.d(TAG, "createUserWithEmail:success");
                                Toast.makeText(Activity_create_account.this, "Registration successful", Toast.LENGTH_SHORT).show();

                                //add all user data to the DB
                                addToDB();

                                //after registration complete direct user to the Activity_login
                                startActivity(new Intent(Activity_create_account.this, Activity_logIn.class));
                            } else {
                                Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                Toast.makeText(Activity_create_account.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

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

    //validation function
    private boolean validate(){
        boolean result = false;

        //declare all the data checked
        String name = userName.getText().toString();
        String password = Password.getText().toString();
        String email = EmailAddress.getText().toString();
        String firstname = first_name.getText().toString();
        String lastname = last_name.getText().toString();
        String verify_pass = verify.getText().toString();
        CheckBox checkbox = findViewById(R.id.chBTerms);


        //check if the username is not empty, passowrds match, user conditions are accepted
        if(name.isEmpty() || password.isEmpty() || email.isEmpty() || firstname.isEmpty() || lastname.isEmpty()){
            Toast.makeText(this, "Please, enter all the details", Toast.LENGTH_SHORT).show();
        } else if(!verify_pass.equals(password)){
            Toast.makeText(this, "Please, enter same passwords", Toast.LENGTH_SHORT).show();
        } else if(!checkbox.isChecked()){
            Toast.makeText(this, "Please, agree to the Terms and Privacy Policy", Toast.LENGTH_SHORT).show();
        } else {
            result = true;
        }
        return result;
    }

    //add user data to the database if the registration is successful
    public void addToDB(){
        first_name = (EditText)findViewById(R.id.first_name);
        Object fname = first_name;

        last_name = (EditText)findViewById(R.id.last_name);
        Object lname = last_name;

        EmailAddress = (EditText)findViewById(R.id.EmailAddress);
        Object eadress = EmailAddress;

        userName = (EditText)findViewById(R.id.username);
        Object uname = EmailAddress;

        // Create a new user with a first and last name
        Map<String, Object> user = new HashMap<>();

        user.put("First name", fname);
        user.put("Last name", lname);
        user.put("Email", eadress);
        user.put("Username", uname);

// Add a new document with a generated ID
        db.collection("users")
                .add(user)
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
}




