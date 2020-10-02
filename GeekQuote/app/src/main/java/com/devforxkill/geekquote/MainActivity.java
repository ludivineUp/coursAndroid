package com.devforxkill.geekquote;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.devforxkill.geekquote.model.Quote;

import java.time.LocalDate;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // tableau dynamique de Quotes
    private ArrayList<Quote> quotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        quotes = new ArrayList<>();
        setContentView(R.layout.activity_main);
        initQuotes();
    }

    private void initQuotes(){
        String[] quoteExamples = getResources().getStringArray(R.array.ex_qotes);
        for(String s : quoteExamples){
            // date actuelle : LocalDate.now()
            // Attention les dates sont complexes à utiliser en java
            Quote q = new Quote(s,0, LocalDate.now());
            quotes.add(q);
            // ajouter la citation dans la vue
            addQuoteView(q);
        }
    }

    public void addQuote(View view){
        // ajouter la quote dans l array list
        String stringQuote = ((TextView) findViewById(R.id.quote_input)).getText().toString();
        int ratingQuote = ((RatingBar) findViewById(R.id.quote_rating)).getNumStars();
        Quote q = new Quote(stringQuote,ratingQuote, LocalDate.now());
        quotes.add(q);
        // affiche la nouvelle citation dans la vue
        addQuoteView(q);
    }

    private void addQuoteView(Quote q) {
        LinearLayout layout = (LinearLayout) findViewById(R.id.listscroll);
        TextView tv = new TextView(this);
        tv.setTextSize(32);
        tv.setText(q.getStrQuote());
        if(quotes.size() % 2 == 0){
            tv.setBackgroundResource(R.color.colorbgQuoteDark);
        }else{
            tv.setBackgroundResource(R.color.colorbgQuotelight);
        }
        layout.addView(tv);
    }
}