package com.devforxkill.layoutdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ScrollViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view);
        LinearLayout layout = findViewById(R.id.layoutforscroll);
        ArrayList<String> tab = new ArrayList<>();
        for(int i = 0; i < 50; i++){
            tab.add(""+ i +" : azertyyuiopmlkjhgfdsqnbvcxwhfpebigbteihapbitpebietp");
            TextView view = new TextView(this);
            view.setText(tab.get(i));
            layout.addView(view);
        }
    }
}