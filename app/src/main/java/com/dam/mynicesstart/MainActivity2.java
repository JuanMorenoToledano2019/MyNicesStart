package com.dam.mynicesstart;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class MainActivity2 extends AppCompatActivity {

        ImageView ivImagen2;
        Button btnBoton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ivImagen2 = findViewById(R.id.ivImagen2);
        btnBoton3 = findViewById(R.id.btnBoton3);
        Glide.with(this)
                .load("https://images.unsplash.com/photo-1565214975484-3cfa9e56f914?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1482&q=80")
//                .apply(new RequestOptions()
                .centerCrop()
                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.colorAccent)))
                .transition(DrawableTransitionOptions.withCrossFade(1000))
//                )
                .into(ivImagen2);

    }


    public void acceder2(View view) {
        Intent i = new Intent(this,SignUpActivity.class);
        startActivity(i);
    }
}
