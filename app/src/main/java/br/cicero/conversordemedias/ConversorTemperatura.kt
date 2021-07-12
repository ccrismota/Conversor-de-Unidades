package br.cicero.conversordemedias

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.*

class ConversorTemperatura : AppCompatActivity() {

    var unidades = arrayOf("Celcius (°C)", "Kelvin (K)", "Faherenheit(°F)")
    var selecao = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversor_temperatura)

        //Carregar Componentes
        val spinner = findViewById<Spinner>(R.id.spinnerTemperatura)
        val txtResultadoTemperatura = findViewById<TextView>(R.id.txtResultadoTemperatura)
        val txtEditNumber = findViewById<TextView>(R.id.editTextNumberTemperatura)
        val btnCalcularTemperatura = findViewById<Button>(R.id.btnTemperatura)

        //Criar Array Adapter

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, unidades)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                selecao = position
            }
        }
        btnCalcularTemperatura.setOnClickListener() {
            val valor = txtEditNumber.text.toString()

            if (valor != "") {

                when (selecao) {

                    0 -> {
                        var texto = "Kelvin = "
                        texto += valor.toDouble() + 273.15f
                        texto += "K \nFaherenheit = "
                        texto += valor.toDouble() * 1.8f + 32f
                        texto += "°F"
                        txtResultadoTemperatura.text = texto
                    }

                    1 -> {
                        var texto = "Celcius = "
                        texto += valor.toDouble() - 273.15f
                        texto += "°C \nFaherenheit = "
                        texto += (valor.toDouble() - 273.15f) * 1.8f + 32f
                        texto += "°F"
                        txtResultadoTemperatura.text = texto
                    }

                    2 -> {
                        var texto = "Celcius = "
                        texto += (valor.toDouble() - 32f) / 1.8f
                        texto += "°C \nKelvin = "
                        texto += (valor.toDouble() - 32f) / 1.8f + 273.15f
                        texto += "K"
                        txtResultadoTemperatura.text = texto
                    }
                }

            } else {
                txtResultadoTemperatura.text = "Adicione um valor para converter"
            }
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item?.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)

    }
}

