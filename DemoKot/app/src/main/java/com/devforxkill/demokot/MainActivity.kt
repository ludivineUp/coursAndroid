package com.devforxkill.demokot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    // Array : taille fixe
    lateinit var quotes : ArrayList<Quote>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initQuotes()
        // plus besoin du findViewById, on passe directement par l'id donné dans la vue
        titleDemoKot.setText("Bonjour !!!!")
    }

    private fun initQuotes() {
        quotes = ArrayList<Quote>()
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