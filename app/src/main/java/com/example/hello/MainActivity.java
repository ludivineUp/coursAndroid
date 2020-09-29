package com.example.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    // string constante qui est liée à la classe et non à l'objet
    // MainActivity.keyMessage pour y accéder directement grâce à static
    // pas static MainActivity ma = new MainActivity(). ma.keyMessage si pas static
    public final static String keyMessage = "com.example.hello.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // l'objet R est généré par Android qui représente les ressources (tout ce qui n'est pas code)
        // pour les débutants, ça va créer 50% de vos bugs
        // ON NE TOUCHE JAMAIS A LA CLASSE R
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view){
        // on récupère l'entrée user et on va l'afficher dans les logs
        // R = regroupe toutes les ressources (IHM, img, etc..)
        // R.id.inputText donne l'id de l'input de la vue principale
        EditText inputUser = (EditText) findViewById(R.id.inputText);
        String mot = inputUser.getText().toString();
        Log.d("message",mot);
        // pour communiquer entre les activités : Intent
        // ~mémoire partagé de toutes les activités d'une appli
        Intent intent = new Intent(this, ShowWordActivity.class);
        intent.putExtra(keyMessage, mot);
        startActivity(intent);
    }
}