package com.example.aplicacion

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class masaCorporal : AppCompatActivity() {
    private var icmText: String = ""
    private var imc: Double = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_masa_corporal)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        regresar()

        val icmMessage=findViewById<TextView>(R.id.textView_calicm)
        val viewIMC=findViewById<TextView>(R.id.viewIMC)
        val buttonCalcular = findViewById<Button>(R.id.button_calcularICM)
        buttonCalcular.setOnClickListener(){
            calcularICM()
            val msgLatLong =  String.format("Tu icm es de: %s", icmText)
            icmMessage.setText(msgLatLong)
            viewIMC.setText(imc.toString())
        }
    }

    private fun regresar() {
        val buttonRegresar = findViewById<Button>(R.id.button_regresar)
        buttonRegresar.setOnClickListener() {
            val cambiar_ventana = Intent(this, MainActivity::class.java)
            startActivity(cambiar_ventana)
        }
    }

    private fun calcularICM(){
        val peso = findViewById<EditText>(R.id.peso)
        val altura = findViewById<EditText>(R.id.altura)
        imc = peso.text.toString().toDouble() / (altura.text.toString().toDouble() * altura.text.toString().toDouble())

        icmText = (if (imc < 18.5) {
            "Bajo peso"
        } else if (imc > 18.51 && imc < 24.9) {
            "Peso normal"
        } else if (imc > 25 && imc < 29.9) {
            "Sobrepeso"
        } else {
            "Obesidad"
        })
    }

}