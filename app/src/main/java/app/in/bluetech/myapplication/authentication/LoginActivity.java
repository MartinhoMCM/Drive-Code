package app.in.bluetech.myapplication.authentication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import app.in.bluetech.myapplication.*;
import app.in.bluetech.myapplication.*;


public class LoginActivity extends AppCompatActivity  {

    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;

    private String email, password;
    private ProgressBar progressBar;
    private Button entrar;

    EditText Input_password, Input_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth =FirebaseAuth.getInstance();
        firebaseUser=firebaseAuth.getCurrentUser();
        progressBar = findViewById(R.id.progressBar_login);

        CallDirectly();

        Input_email = findViewById(R.id.email_login);
        Input_password = findViewById(R.id.password_login);

        progressBar.setVisibility(View.VISIBLE);

    }

    private void CallDirectly() {

        if(firebaseUser!=null)
        {
            startActivity(new Intent(LoginActivity.this, DrawerActivity.class));
        }
    }

    public void Entrar(View v) {

                String email =Input_email.getText().toString();
                String password=Input_password.getText().toString();

                if(email.length()!=0 && password.length()!=0){

                    firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if(task.isSuccessful())
                            {
                                FirebaseUser getUser =firebaseAuth.getCurrentUser();
                                startActivity( new Intent(LoginActivity.this, DrawerActivity.class));
                                finish();
                            }
                            else

                            {
                                progressBar.setVisibility(View.GONE);
                                Toast.makeText(getApplicationContext(), "Autenticação falhou. Tens a certeza que estás registrado?",
                                        Toast.LENGTH_SHORT).show();
                                //startActivity( new Intent(LoginActivity.this, DrawerActivity.class));
                               // finish();
                            }

                        }
                    });
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Campos vazios", Toast.LENGTH_SHORT).show();
                }



    }
    @Override
    protected void onResume() {
        super.onResume();
        progressBar.setVisibility(View.GONE);
    }
}
