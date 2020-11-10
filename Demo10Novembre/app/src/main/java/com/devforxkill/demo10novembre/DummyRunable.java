package com.devforxkill.demo10novembre;

import android.util.Log;

// Thread implments Runable
// thread, runable kif kif bourico
public class DummyRunable implements Runnable {
    @Override
    public void run() {
        for(int i = 0; i < 20; i++) {
            Log.d("RUNNABLE","le compteur est à "+ i);
        }
    }
}
