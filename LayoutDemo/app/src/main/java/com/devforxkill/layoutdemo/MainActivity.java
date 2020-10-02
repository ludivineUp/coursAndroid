package com.devforxkill.layoutdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Listener : c'est un écouteur d'évènement
        // event  : onClick, onLongClick, onFocusChange, onKey, onTouch, onCreateContextMenu
        Button relativeBtn = findViewById(R.id.relativeBtn);
        relativeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,  RelativeActivity.class);
                // je démarre la Relative activity
                startActivity(intent);
            }
        });
        Button tableBtn = findViewById(R.id.tableBtn);
        tableBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, TableActivity.class);
                Intent intent = new Intent(MainActivity.this, ScrollViewActivity.class);
                // je démarre la Relative activity
                startActivity(intent);
            }
        });
    }

    // ne pas oublir le param View pour lier la méthode au layout
    public void launchRelative(View view){
        Log.d("DEBUG","launchRelative");
        // intent relie deux activité, celle de départ et celle qui va être lancée (RelativeActivity)
        Intent intent = new Intent(this, RelativeActivity.class);
        // je démarre la Relative activity
        startActivity(intent);
    }
}