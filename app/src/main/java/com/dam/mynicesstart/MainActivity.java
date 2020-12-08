package com.dam.mynicesstart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SwipeRefreshLayout swipeLayout;
    ImageView imgLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);

        getSupportActionBar().setDisplayUseLogoEnabled(true);

        ExpandableCardView card = findViewById(R.id.profile);
        card.setOnExpandedListener(new ExpandableCardView.OnExpandedListener() {
          @Override
          public void onExpandChanged(View v, boolean isExpanded) {
               Toast.makeText(MainActivity.this, isExpanded ? "Expanded!" : "Collapsed!", Toast.LENGTH_SHORT).show();
    }
    });

    TextView mycontext = findViewById(R.id.longtap);
     registerForContextMenu(mycontext);


    }
}