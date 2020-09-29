package com.devforxkill.lyfecycleactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    // quand on ouvre l'appli et il appelle de suite onStart
    protected void onCreate(Bundle savedInstanceState){
        // super = référence à la mère, ici AppCompatActivity
        // permets d'appeler une méthode ou un attribut de la mère tout en
        // redéfinissant dans la classe fille
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("LYFECYCLE","onCreate");

        // Tout ce qui est déclaré dans le layout xml
        // peut être déclaré en code Java/kotlin
        /*LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        TextView tv = new TextView(this);
        tv.setText("not to do again");

        TextView tv2 = new TextView(this);
        tv2.setText("never do again");
        layout.addView(tv);
        layout.addView(tv2);

        setContentView(layout);*/
    }

    @Override
    // quand l'appli démarre
    protected void onStart(){
        super.onStart();
        Log.d("LYFECYCLE","onStart");
    }

    @Override
    // quand on revient sur l'appli après avoir perdu le focus
    // appelle toujours onStart()
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
    // quand l'appli perd le focus
    // mais attention vous pouvez slipter l'écran en deux
    protected void onPause(){
        super.onPause();
        Log.d("LYFECYCLE","onPause");
    }

    @Override
    // quand l'appli n'est plus visible
    protected void onStop(){
        super.onStop();
        Log.d("LYFECYCLE","onStop");
    }

    @Override
    // appelée juste avant la fermutre définitive de l'appli
    protected void onDestroy(){
        super.onDestroy();
        Log.d("LYFECYCLE","onDestroy");
    }
}