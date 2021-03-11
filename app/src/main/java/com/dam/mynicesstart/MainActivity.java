package com.dam.mynicesstart;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Toast;

import com.alespero.expandablecardview.ExpandableCardView;
import com.google.android.material.snackbar.Snackbar;

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
                Toast.makeText(MainActivity.this, isExpanded ? "Expanded!" :
                        "Collapsed!", Toast.LENGTH_SHORT).show();
            }
        });

        ImageView mycontext = findViewById(R.id.avatar);
        registerForContextMenu(mycontext);

        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.myswipe);
        swipeLayout.setOnRefreshListener(mOnRefreshListener);


    }

    protected SwipeRefreshLayout.OnRefreshListener
            mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {

//          Toast toast0 = Toast.makeText(MainActivity.this, "going
//                    swipeREFRESH", Toast.LENGTH_LONG);
//                    toast0.show();
//            swipeLayout.setRefreshing(false);


           final ConstraintLayout mLayout = (ConstraintLayout) findViewById(R.id.constraint);

//            final RelativeLayout mLayout = (RelativeLayout) findViewById(R.id.activity_main_context);

            Snackbar snackbar = Snackbar
                    .make(mLayout, "fancy a Snack while you refresh?", Snackbar.LENGTH_LONG)
                    .setAction("UNDO", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Snackbar snackbar1 = Snackbar.make(mLayout, "Action is restored!", Snackbar.LENGTH_SHORT);
                            snackbar1.show();
                        }
                    });

            snackbar.show();
            swipeLayout.setRefreshing(false);
        }
    };

    public void showAlertDialogButtonClicked(MainActivity view) {
        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //el dialogo estandar tiene título/icono pero podemos sustituirlo
        //por un XML a medida
        builder.setTitle("Achtung!");
        builder.setMessage("Where do you go?");
        //builder.setIcon(R.drawable.ic_action_name_dark);
        // un XML a medida para el diálogo

 //       builder.setView(getLayoutInflater().inflate(R.layout.alertdialog_view,  null));

        builder.setPositiveButton("Glide", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // do something like...
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        startActivity(intent);
                        dialog.dismiss();
                    }
                });
        builder.setNegativeButton("ChatBot", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // do something like...
                        Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                        startActivity(intent);
                        dialog.dismiss();
                    }
                });

        builder.setNeutralButton("MotionLayout", new
                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // do something like...
                        Intent intent = new Intent(MainActivity.this, ConstraintSet.Motion.class);
                        startActivity(intent);
                        dialog.dismiss();
                    }
                });
        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast toast = Toast.makeText(this,"going APPBAR CAMERA",Toast.LENGTH_LONG );
            toast.show();
        }
        if (id == R.id.camera) {

            showAlertDialogButtonClicked(MainActivity.this);

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_context, menu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.edit:
                Toast toast = Toast.makeText(this, "going CONTEXT CAMERA", Toast.LENGTH_LONG);
                toast.show();
                break;
            case R.id.delete:
                Toast toast2 = Toast.makeText(this, "going CONTEXT SETTINGS", Toast.LENGTH_LONG);
                toast2.show();
                break;
        }
        return super.onContextItemSelected(item);
    }

    public void openScrolling(View view) {
    }
}