package com.dam.mynicesstart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LoginActivityAlco extends AppCompatActivity {

    TextView mSignUpTextview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_alco);

        TextView mSignUpTextview = (TextView) findViewById(R.id.signup_text);



        mSignUpTextview.setOnClickListener(new View.OnClickListener().OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(LoginActivityAlco.this, SignUpActivity.class);
                startActivity(intent);


            }
        });


    }
}