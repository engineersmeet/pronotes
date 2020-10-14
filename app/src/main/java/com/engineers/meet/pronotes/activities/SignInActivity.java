package com.engineers.meet.pronotes.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.engineers.meet.pronotes.R;

public class SignInActivity extends AppCompatActivity {

    EditText userNameEditText;
    EditText passwordEditText;

    TextView signInTextView;

    String username = "pravin";
    String password = "07070909";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        init();
        setListeners();
    }

    private void setListeners() {
        signInTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isValidate()){
                    if (userNameEditText.getText().toString().equals(username) &&
                            passwordEditText.getText().toString().equals(password)) {
                        Intent intent = new Intent();
                        intent.putExtra("username", username);
                        setResult(200, intent);
                        finish();
                    }else {
                        Toast.makeText(SignInActivity.this, "Sign in failed, please try again", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }

    private boolean isValidate() {
        if(userNameEditText.getText().toString().isEmpty()){
            userNameEditText.setError("Please enter username!");
            return false;
        }else if(passwordEditText.getText().toString().isEmpty()){
            passwordEditText.setError("Please enter password!");
            return false;
        }
        return true;
    }

    private void init() {
        userNameEditText = findViewById(R.id.sign_in_user_name);
        passwordEditText = findViewById(R.id.sign_in_user_pass);

        signInTextView = findViewById(R.id.sign_in_button);
    }
}
