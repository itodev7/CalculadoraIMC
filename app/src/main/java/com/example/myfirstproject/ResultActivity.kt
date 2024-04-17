package com.example.myfirstproject

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvClassificacao = findViewById<TextView>(R.id.textview_classificacao)
        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        tvResult.text = result.toString()

        val classificacao = if (result < 18.6f) {
             "Abaixo do peso"
        } else if(result in 18.6f..24.9f) {
             "Peso ideal"
        } else if(result in 25.0f..29.9f) {
             "Levemente acima do peso"
        } else if(result in 30f..34.9f) {
             "Obesidade grau 1"
        } else if(result in 35f..39.9f) {
            "Obesidade grau 2"
        } else {
             "Obesidade grau 3"
        }

        tvClassificacao.text = getString(R.string.message_classificacao, classificacao)

        }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }

    }
