package com.devforxkill.demo10novembre;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import static android.support.v4.app.FragmentTransaction.TRANSIT_ENTER_MASK;
import static android.support.v4.app.FragmentTransaction.TRANSIT_EXIT_MASK;

public class MainActivity extends AppCompatActivity implements InputFragment.OnButtonClickedListener {

    private String nameFile = "example.txt";
    private OutpuFragment outpuFragment;
    private InputFragment inputFragment;

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

        //afficher le premier fragment en dyn
        // Wargning : 1 fragment par placeholder
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        inputFragment = new InputFragment();
        // le fragment aura le flag input
        transaction.add(R.id.layoutmain, inputFragment, "input");
        transaction.commit();
        /*FragmentTransaction transaction2 = manager.beginTransaction();
        outpuFragment = new OutpuFragment();
        transaction2.replace(R.id.layoutmain, outpuFragment);
        transaction2.commit();*/


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

    @Override
    public void onButtonClicked(View view) {
        // on remplace uniquement si l'inputfragement est affichée
        InputFragment test = (InputFragment) getSupportFragmentManager().findFragmentByTag("input");
        Log.d("MAIN", "EST CE NULL "+test);
        if(test == null || test.isAdded()) {
                //ATTENTION : les param des fragments ne sont là que pour les entrées des fragments
                String name = inputFragment.getEntreeuser().getText().toString();
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.setCustomAnimations(android.R.anim.slide_in_left,
                        android.R.anim.slide_out_right);
                outpuFragment = new OutpuFragment();
                Bundle bundle = new Bundle();
                bundle.putString("nameToDisplay", name);
                outpuFragment.setArguments(bundle);
                // le fragment aura le flag output
                transaction.replace(R.id.layoutmain, outpuFragment, "ouput");
                transaction.commit();
                Log.d("Fragment", "on a cliké sur le bouton");
        }
    }
}