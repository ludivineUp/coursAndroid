package com.devforxkill.lyfecycleactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // super = référence à la mère, ici AppCompatActivity
        // permets d'appeler une méthode ou un attribut de la mère tout en
        // redéfinissant dans la classe fille
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("LYFECYCLE","onCreate");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d("LYFECYCLE","onStart");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d("LYFECYCLE","onRestart");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d("LYFECYCLE","onResume");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d("LYFECYCLE","onPause");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d("LYFECYCLE","onStop");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("LYFECYCLE","onDestroy");
    }
}