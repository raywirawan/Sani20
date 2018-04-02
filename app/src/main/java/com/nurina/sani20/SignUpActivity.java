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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    private ProgressBar progressBar;
    private Button SignUpButton;
    private FirebaseAuth mAuth;
    private EditText editTextUsername, editTextPassword, editTextEmail, editTextConfirmPassword;

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

        SignUpButton = findViewById(R.id.signUpButton);
        SignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });

    }
    private void navigateToMainActivity() {
        Intent intent = new Intent(SignUpActivity.this, Home.class);
        startActivity(intent);
    }

    private void registerUser() {
        final String username = editTextUsername.getText().toString().trim();
        final String email = editTextEmail.getText().toString().trim();
        final String password = editTextPassword.getText().toString().trim();
        String confirmPass = editTextConfirmPassword.getText().toString().trim();
        if (username.isEmpty()) {
            editTextUsername.setError("Username is required");
            editTextUsername.requestFocus();
        }
        if (username.contains(" ")) {
            editTextUsername.setError("Username is not valid");
        }
        if (email.isEmpty()) {
            editTextEmail.setError("Email is required");
            editTextEmail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmail.setError("Email is not valid");
        }
        if (password.isEmpty()) {
            editTextPassword.setError("Password is required");
            editTextPassword.requestFocus();
            return;
        }
        if (password.length() < 6) {
            editTextPassword.setError("Password must contains 6 characters");
            editTextPassword.requestFocus();
            return;
        }
        if (!confirmPass.equals(password)) {
            editTextConfirmPassword.setError("Password do not match");
            editTextPassword.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            progressBar.setVisibility(View.GONE);
                            toast("User Successfully Registered");
                            signIn(email, password, username);

                        } else {
                            if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                                toast("Email is already taken");
                                progressBar.setVisibility(View.GONE);
                            } else {
                                toast("Error occured, please try again");
                                progressBar.setVisibility(View.GONE);
                            }
                        }
                    }
                });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.signUpButton:
                registerUser();
                break;
        }
    }

    public void navigateToHome() {
        Intent intent = new Intent(SignUpActivity.this, Home.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void toast(String a) {
        Toast.makeText(getApplicationContext(), a, Toast.LENGTH_SHORT).show();
    }

    public void signIn(String ema, String psw, final String usrname) {
        mAuth.signInWithEmailAndPassword(ema, psw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    final FirebaseUser user = mAuth.getCurrentUser();

                    if (user != null) {
                        UserProfileChangeRequest profile = new UserProfileChangeRequest.Builder()
                                .setDisplayName(usrname).build();

                        user.updateProfile(profile)
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            toast("Welcome "+FirebaseAuth.getInstance().getCurrentUser().getDisplayName());
                                            navigateToHome();
                                        } else {
                                            toast("username can't be updated");
                                        }
                                    }
                                });
                    }
                } else {
                    toast("Could not sign in, please try again");
                }
            }
        });

    }
}
