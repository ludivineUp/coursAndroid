package com.devforxkill.demo10novembre;

import android.util.Log;

// thread = processus de l'application qui permet de faire de l'asynchrone
public class DummyThread extends Thread{

    private int number;

    public DummyThread(int number){
        this.number = number;
    }

    public void run(){
        for(int i = 0; i < 20; i++) {
            Log.d("THREAD "+number,"le compteur est à "+ i);
        }
    }
}
