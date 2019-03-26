package app.in.bluetech.myapplication.authentication;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;



import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;



import app.in.bluetech.myapplication.*;
public class RegisterActivity extends AppCompatActivity  {

    EditText input_email, input_password;
    Button  btnregister;
    ProgressBar progressBar;

    private FirebaseAuth mFirebaseAuth;
    private String TAG="firebase";
    private  boolean connected=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Get Firabse instance
        mFirebaseAuth = FirebaseAuth.getInstance();

        input_email = findViewById(R.id.email);
        input_password = findViewById(R.id.password);

        btnregister = findViewById(R.id.sign_up_button);
        progressBar = findViewById(R.id.progressBar);



        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = input_email.getText().toString();
                String password = input_password.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Introduza o email", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Introduza a palavra passe", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Palavra passe muito curta, no mínimo 5 caracteres", Toast.LENGTH_SHORT).show();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                ConnectivityManager connectivityManager
                        = (ConnectivityManager)getSystemService(getApplication().CONNECTIVITY_SERVICE);
                if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                        connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
                    //we are connected to a network
                    createAccount();
                    Toast.makeText(getApplicationContext(), "Tem conexão a internet", Toast.LENGTH_SHORT).show();
                }
                else
                {

                    Toast.makeText(getApplicationContext(), "Sem conexão a internet", Toast.LENGTH_SHORT).show();
                }







            }
        });

    }

    private void createAccount() {



         mFirebaseAuth.createUserWithEmailAndPassword(input_email.getText().toString(), input_password.getText().toString()).
                 addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                     @Override
                     public void onComplete(@NonNull Task<AuthResult> task) {
                         if(task.isSuccessful())
                         {
                             Log.d(TAG, "createUserWithEmail:success");
                             FirebaseUser user =mFirebaseAuth.getCurrentUser();
                             startActivity(new Intent(RegisterActivity.this, DrawerActivity.class));
                             finish();

                         }
                         else
                         {
                             // If sign in fails, display a message to the user.
                             Log.w(TAG, "createUserWithEmail:failure", task.getException());
                             Toast.makeText(getApplicationContext(), "Authentication failed.",
                                     Toast.LENGTH_SHORT).show();
                         }
                     }
                 });
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = mFirebaseAuth.getCurrentUser();
        //updateUI
    }

    @Override
    protected void onResume() {
        super.onResume();

        progressBar.setVisibility(View.GONE);
    }


    public void Login(View view) {
        startActivity( new Intent(RegisterActivity.this, LoginActivity.class));
        finish();
    }


}