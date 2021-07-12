package br.cicero.conversordemedias

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnComprimento = findViewById<ImageButton>(R.id.btnComprimento)

        btnComprimento.setOnClickListener() {
            val intent = Intent(this, ConversorComprimento::class.java)
            startActivity(intent)
        }

        val btnDados = findViewById<ImageButton>(R.id.btnDados)

        btnDados.setOnClickListener() {
            val intent = Intent(this, ConversonDados::class.java)
            startActivity(intent)
        }
        val btnTemperatura = findViewById<ImageButton>(R.id.btnTemperatura)

        btnTemperatura.setOnClickListener() {
            val intent = Intent(this, ConversorTemperatura::class.java)
            startActivity(intent)
        }
        val btnPeso = findViewById<ImageButton>(R.id.btnPeso)

        btnPeso.setOnClickListener() {
            val intent = Intent(this, ConverterPeso::class.java)
            startActivity(intent)
        }

        val btnTempo = findViewById<ImageButton>(R.id.btnTempo)

        btnTempo.setOnClickListener(){
            val intent = Intent(this, ConversorTempo::class.java)
            startActivity(intent)
        }

        val btnVelocidade = findViewById<ImageButton>(R.id.btnVelocidade)

        btnVelocidade.setOnClickListener() {
        val intent = Intent(this, ConversorVelocidade::class.java)
            startActivity(intent)
        }
    }
}