package com.dam.mynicesstart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

/**
 * Ventana de bienvenida con una animacion y un scrim
 * @author Juan Moreno Toledano
 * @see LoginActivityAlco
 */
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        ImageView mForest = findViewById(R.id.backforest);



        Glide.with(this)
                .load(R.drawable.girl)
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade(500))
                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.colorPrimary)))
//                 .circleCrop()
//                  .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(mForest);


//        "https://images.unsplash.com/photo-1565214975484-3cfa9e56f914?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1482&q=80"

        TextView mySubtitle = (TextView) findViewById(R.id.eslogan);
        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.fadein);
        mySubtitle.startAnimation(myanim);

        openApp(true);

    }

    private void openApp(boolean locationPermission) {

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity
                        .this, LoginActivityAlco.class);
                startActivity(intent);
            }
        }, 5000);


    }


/*   private void openApp(boolean locationPermission) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity
                        .this, LoginActivityAlco.class);
                startActivity(intent);
                finish();
            }
        }, 5000);
    }*/


}