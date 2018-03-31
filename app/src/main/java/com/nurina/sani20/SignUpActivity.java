package com.nurina.sani20;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity  implements View.OnClickListener{

    ProgressBar progressBar;
    private Button SignUpButton;
    private FirebaseAuth mAuth;
    EditText editTextUsername, editTextPassword, editTextEmail, editTextConfirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        editTextUsername = findViewById(R.id.usernameEditTextSignUp);
        editTextEmail = findViewById(R.id.emailEditTextSignUp);
        editTextPassword = findViewById(R.id.passwordEditTextSignUp);
        editTextConfirmPassword = findViewById(R.id.ConfirmPasswordEditTextSignUp);
        progressBar = findViewById(R.id.progressSignUp);

        mAuth = FirebaseAuth.getInstance();

        SignUpButton= findViewById(R.id.signUpButton);
        SignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });

    }

    private void navigateToMainActivity(){
        Intent intent= new Intent (SignUpActivity.this,Home.class);
        startActivity(intent);
    }
    private void registerUser(){
        String username = editTextUsername.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String confirmPass = editTextConfirmPassword.getText().toString().trim();
        if (username.isEmpty()){
            editTextUsername.setError("Username is required");
            editTextUsername.requestFocus();
        }
        if (username.contains(" ")){
            editTextUsername.setError("Username is not valid");
        }
        if (email.isEmpty()){
            editTextEmail.setError("Email is required");
            editTextEmail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextEmail.setError("Email is not valid");
        }
        if (password.isEmpty()){
            editTextPassword.setError("Password is required");
            editTextPassword.requestFocus();
            return;
        }
        if (password.length()<6){
            editTextPassword.setError("Password must contains 6 characters");
            editTextPassword.requestFocus();
            return;
        }
        if (!confirmPass.equals(password)){
            editTextConfirmPassword.setError("Password do not match");
            editTextPassword.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(getApplicationContext(), "User Successfully Registered", Toast.LENGTH_SHORT).show();
                    navigateToHome();
                }
                else {
                Toast.makeText(getApplicationContext(), "Error occured, please try again", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.signUpButton:
                registerUser();
                break;
        }
    }
    public void navigateToHome() {
        Intent intent = new Intent(SignUpActivity.this, Home.class);
        startActivity(intent);
    }
}
