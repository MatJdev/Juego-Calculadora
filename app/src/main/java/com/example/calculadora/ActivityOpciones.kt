package com.example.calculadora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ActivityOpciones : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opciones)

        val button2 = findViewById<Button>(R.id.button2)
        val button1 = findViewById<Button>(R.id.button)

        button1.setOnClickListener {
            startActivity(Intent(this, ActivityFormulas::class.java))
        }

        button2.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}