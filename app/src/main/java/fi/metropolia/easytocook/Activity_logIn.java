package fi.metropolia.easytocook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Activity_logIn extends AppCompatActivity {

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        findViewById(R.id.btnToProfile).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentProfile = new Intent(getApplicationContext(), Activity_userProfile.class);
                startActivity(intentProfile);
            }


        });
    }*/

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter = 5;
    private TextView userRegistration;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;
    private TextView forgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        Name = (EditText)findViewById(R.id.EmailAddress);
        Password = (EditText)findViewById(R.id.Password);
        Info = (TextView)findViewById(R.id.tvInfo);
        Login = (Button)findViewById(R.id.btnToProfile);


        Info.setText("No of attempts remaining: 5");

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

        FirebaseUser user = firebaseAuth.getCurrentUser();

        /*if(user != null){
            finish();
            startActivity(new Intent(Activity_logIn.this, MainActivity.class));
        }*/

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });

    }

    private void validate(String userName, String userPassword) {

        progressDialog.setMessage("You can subscribe to my channel until you are verified!");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(userName, userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    progressDialog.dismiss();
                    Toast.makeText(Activity_logIn.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent intentProfile = new Intent(getApplicationContext(), Activity_userProfile.class);
                    startActivity(intentProfile);

                }else{
                    Toast.makeText(Activity_logIn.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    counter--;
                    Info.setText("No of attempts remaining: " + counter);
                    progressDialog.dismiss();
                    if(counter == 0){
                        Login.setEnabled(false);
                    }
                }
            }
        });
    }
}

