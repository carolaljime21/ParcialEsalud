package com.example.aplicacion

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Aplicacion)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        navegar()
    }

    private fun navegar() {
        val buttonmasaCorporal = findViewById<Button>(R.id.button_masaCorporal)
        buttonmasaCorporal.setOnClickListener() {
            val cambiar_ventana = Intent(this, masaCorporal::class.java)
            startActivity(cambiar_ventana)
        }

        val buttonPesoIdeal = findViewById<Button>(R.id.button_pesoIdeal)
        buttonPesoIdeal.setOnClickListener() {
            val cambiar_ventana = Intent(this, pesoIdeal::class.java)
            startActivity(cambiar_ventana)
        }
    }
}

