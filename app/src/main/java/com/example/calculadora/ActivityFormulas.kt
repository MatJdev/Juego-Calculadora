package com.example.calculadora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ActivityFormulas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulas)

        val botonvolver = findViewById<Button>(R.id.botonVolver)

        botonvolver.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}