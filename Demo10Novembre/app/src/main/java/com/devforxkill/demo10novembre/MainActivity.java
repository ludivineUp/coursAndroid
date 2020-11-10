package com.devforxkill.demo10novembre;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    private String nameFile = "example.txt";

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // THREAD
        // on va tourner le thread
        /*DummyThread dt = new DummyThread();
        // pour lancer le thread en async : start
        */
        // CONCURRENT
        Executor executor = Executors.newFixedThreadPool(4);
        // on crée et on lance en même temps donc 4 threads async
        for(int i = 0 ; i < 4; i++){
            // on n'a pas la main sur l'exécution interne des threads
            executor.execute(new DummyThread(i));
        }
        for(int i = 0; i < 20; i++) {
            Log.d("MAIN ACTIVITY","le compteur est à "+ i);
        }
        // executor : lancer plusieurs threads en même temps de manière plus performante
        //saveData();
        readData();
        // notification TOAST
        Toast.makeText(getApplicationContext(), "toto", Toast.LENGTH_SHORT).show();
    }

    // stockage interne sous format de fichiers

    // écrire le fichier
    public void saveData(){
        String data = "faut pas pousser mémé dans les orties";
        try{
            // on ouvre le fichier
            FileOutputStream out = this.openFileOutput(nameFile, MODE_PRIVATE);
            // on écrit dedans
            out.write(data.getBytes());
            // on le ferme
            out.close();
        } catch (Exception e){
            Log.d("WRITE",e.getStackTrace().toString());
        }
    }

    // lire le fichier
    public void readData(){
        try{
            FileInputStream in = this.openFileInput(nameFile);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String res = "";
            while((res = br.readLine())!= null){
                Log.d("DATA", res);
            }

        } catch (Exception e){
            Log.d("WRITE",e.getStackTrace().toString());
        }
    }
}