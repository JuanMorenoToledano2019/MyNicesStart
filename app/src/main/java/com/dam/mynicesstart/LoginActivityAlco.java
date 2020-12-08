package com.dam.mynicesstart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class LoginActivityAlco extends AppCompatActivity {

    protected TextView mSignUpTextview;
    protected Button mLoginButton;
    protected TextInputLayout mPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_alco);

        mLoginButton = (Button)findViewById(R.id.btnBoton2);
        mLoginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(LoginActivityAlco.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);


            }
        });

        mSignUpTextview = (TextView)findViewById(R.id.signup_text);
       mSignUpTextview.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(LoginActivityAlco.this, SignUpActivity.class);
                startActivity(intent);


            }
        });


    }
}