package com.example.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

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
    }
}