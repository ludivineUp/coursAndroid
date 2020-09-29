package com.example.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ShowWordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_word);
        // on va récuperer le mot à afficher donné par l'activité principale
        String mot = getIntent().getStringExtra(MainActivity.keyMessage);
        TextView afiche = findViewById(R.id.affiche);
        afiche.setText(mot);
    }
}