package com.example.calculadora

import android.media.AudioAttributes
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
//import kotlin.math.pow
//import kotlin.math.sqrt
import kotlin.math.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etNum1 = findViewById<EditText>(R.id.etNum1)
        val etNum2 = findViewById<EditText>(R.id.etNum2)
        val etNumEsp = findViewById<EditText>(R.id.etNumEsp)
        val btnSuma = findViewById<Button>(R.id.btnSuma)
        val btnResta = findViewById<Button>(R.id.btnResta)
        val btnMulti = findViewById<Button>(R.id.btnMulti)
        val btnDiv = findViewById<Button>(R.id.btnDiv)
        val btnMod = findViewById<Button>(R.id.btnModulo)
        val btnPotencia = findViewById<Button>(R.id.btnPotencia)
        val btnRaiz = findViewById<Button>(R.id.btnRaiz)
        val btnDel = findViewById<Button>(R.id.btnDel)
        val btnIgual = findViewById<Button>(R.id.btnIgual)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)
        val tvOperador = findViewById<TextView>(R.id.tvOp)
        val switch = findViewById<Switch>(R.id.switch1)

        var res = 0.0

        val audioAttributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_GAME)
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .build()

        val soundPool1 = SoundPool.Builder().setAudioAttributes(audioAttributes)
            .setMaxStreams(10).build()

        val sound1 = soundPool1.load(this, R.raw.pulsa_boton,1)
        val sound2 = soundPool1.load(this, R.raw.bb3,1)
        val sound3 = soundPool1.load(this, R.raw.incorrecto,1)

        var pr = false
        switch.setOnCheckedChangeListener { buttonView, isChecked ->
            pr = isChecked
        }

        btnSuma.setOnClickListener {
            tvOperador.text = "+"
            if (pr){
                soundPool1.play(sound1,10f,10f,1,0,1f)
            }

        }
        btnResta.setOnClickListener {
            tvOperador.text = "-"
            if (pr){
                soundPool1.play(sound1,10f,10f,1,0,1f)
            }
        }
        btnMulti.setOnClickListener {
            tvOperador.text = "x"
            if (pr){
                soundPool1.play(sound1,10f,10f,1,0,1f)
            }
        }
        btnDiv.setOnClickListener {
            tvOperador.text = "/"
            if (pr){
                soundPool1.play(sound1,10f,10f,1,0,1f)
            }
        }
        btnMod.setOnClickListener {
            tvOperador.text = "%"
            if (pr){
                soundPool1.play(sound1,10f,10f,1,0,1f)
            }
        }
        btnRaiz.setOnClickListener {
            tvOperador.text = "√"
            if (pr){
                soundPool1.play(sound1,10f,10f,1,0,1f)
            }
        }
        btnPotencia.setOnClickListener {
            tvOperador.text = "()^2"
            if (pr){
                soundPool1.play(sound1,10f,10f,1,0,1f)
            }
        }
        btnDel.setOnClickListener {
            if (pr){
                soundPool1.play(sound1,10f,10f,1,0,1f)
            }
            etNum1.text.clear()
            etNum2.text.clear()
            tvOperador.text = ""
            tvResultado.text = ""
        }

        btnIgual.setOnClickListener {

            if (etNum1.getText().toString().isEmpty()  || etNum2.getText().toString().isEmpty() || tvOperador.getText().toString().isEmpty()){
                tvResultado.text = "Introduzca datos"
            }
            else {
                val num1 = etNum1.text.toString().toDouble()
                val num2 = etNum2.text.toString().toDouble()

                when (tvOperador.text){
                    "+" -> res = num1 + num2
                    "-" -> res = num1 - num2
                    "x" -> res = num1 * num2
                    "/" -> res = num1 / num2
                    "%" -> res = num1 % num2
                    "√" -> res = sqrt(num1)
                    "()^2" -> res = num1.pow(2)
                    else -> tvResultado.text = "Elija operador!"
                }
                tvResultado.text = res.toString()

                if (etNumEsp.getText().toString() == tvResultado.getText().toString()){
                    tvResultado.setBackgroundResource(R.drawable.res_si)
                    if (pr){
                        soundPool1.play(sound2,10f,10f,1,0,1f)
                    }
                }
                else {
                    tvResultado.setBackgroundResource(R.drawable.res_no)
                    if (pr){
                        soundPool1.play(sound3,10f,10f,1,0,1f)
                    }
                }
            }

        }





    }
}