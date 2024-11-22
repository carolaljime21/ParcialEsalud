package com.example.aplicacion

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.text.lowercase
import kotlin.text.toIntOrNull
import kotlin.text.trim

class pesoIdeal : AppCompatActivity() {
    private var pesoIdeal = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_peso_ideal)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        regresar()
        val piMessage=findViewById<TextView>(R.id.textView_calPI)
        val viewPI=findViewById<TextView>(R.id.viewPesoIdeal)
        val buttonCalcular = findViewById<Button>(R.id.button_calcularPI)
        buttonCalcular.setOnClickListener(){
            calcularPI()
            val msgLatLong = String.format("Tu peso ideal es de: %s", pesoIdeal, " kg")
            piMessage.setText(msgLatLong)
            viewPI.setText(pesoIdeal.toString())
        }
    }

    private fun regresar() {
        val buttonRegresar = findViewById<Button>(R.id.button_regresar)
        buttonRegresar.setOnClickListener() {
            val cambiar_ventana = Intent(this, MainActivity::class.java)
            startActivity(cambiar_ventana)
        }
    }

    private fun calcularPI() {
        val alturaText = findViewById<EditText>(R.id.altura).text.toString()
        val sexoText = findViewById<EditText>(R.id.sexo).text.toString()
        var pi = 0
        val altura = alturaText.toIntOrNull() ?: 0
        val sexo = sexoText.trim().lowercase()

        pi = if (sexo == "masculino") {
            altura - 100
        } else if (sexo == "femenino") {
            altura - 105
        } else {
            0
        }
        pesoIdeal = pi
    }
}