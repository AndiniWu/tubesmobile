package com.example.myproperty;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {
    private EditText fullnameTV, usernameTV, emailTV, passwordTV;
    private Button signup_button;
    private ProgressBar progressBar;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();

        initializeUI();

        signup_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerNewUser();
            }
        });

    }

    private void registerNewUser() {
        progressBar.setVisibility(View.VISIBLE);

        String email, password, fullname, username;
        email = emailTV.getText().toString();
        password = passwordTV.getText().toString();
//        fullname = fullnameTV.getText().toString();
//        username = usernameTV.getText().toString();

//        if (TextUtils.isEmpty(fullname)) {
//            Toast.makeText(getApplicationContext(), "Please enter fullname!", Toast.LENGTH_LONG).show();
//            return;
//        }
//        if (TextUtils.isEmpty(username)) {
//            Toast.makeText(getApplicationContext(), "Please enter username!", Toast.LENGTH_LONG).show();
//            return;
//        }
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(), "Please enter email...", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "Please enter password!", Toast.LENGTH_LONG).show();
            return;
        }


        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Registration successful!", Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);

                            Intent intent = new Intent(SignUp.this, Login.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Registration failed! Please try again later", Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
    }

    private void initializeUI() {
//        fullnameTV = findViewById(R.id.fullname);
//        usernameTV = findViewById(R.id.username);
        emailTV = findViewById(R.id.email);
        passwordTV = findViewById(R.id.password);
        signup_button = findViewById(R.id.signup_button);
        progressBar = findViewById(R.id.progressBar);
    }
}
