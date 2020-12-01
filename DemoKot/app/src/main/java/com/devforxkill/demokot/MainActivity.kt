package com.devforxkill.demokot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var quotes : ArrayList<Quote> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initQuotes()
    }

    private fun initQuotes() {
        quotes.add(Quote("toto"))
        quotes.add(Quote("zozo"))
        quotes.forEach {
            var layout = findViewById<LinearLayout>(R.id.layout)
            var tv = TextView(this)
            tv.setText(it.strQuote)
            layout.addView(tv)
        }
    }
}