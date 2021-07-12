package br.cicero.conversordemedias

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class ConversorVelocidade : AppCompatActivity() {

    var unidades = arrayOf("Quilomentro/hora (Km/h)", "Metro/Segundos(m/s)", "Milhas/hora(mph)")
    var selecao = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversor_velocidade)

        //Carregar Componentes

        val spinner = findViewById<Spinner>(R.id.spinnerVelocidade)
        val txtResultadoVelocidade = findViewById<TextView>(R.id.txtResultadoVelocidade)
        val txtEditNumber = findViewById<TextView>(R.id.editTextNumberVelocidade)
        val btnCalcularVelocidade = findViewById<Button>(R.id.btnVelocidade)

        //Carregar Array Adapter

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, unidades)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
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
        btnCalcularVelocidade.setOnClickListener(){
            val valor = txtEditNumber.text.toString()

            if (valor != "") {

                when (selecao) {

                    0 -> {
                        var texto = "Metros/Segundo = "
                        texto += valor.toDouble() / 3.6f
                        texto += " m/s \nMilhas/Hora = "
                        texto += valor.toDouble() / 1.609f
                        texto += " mph"
                        txtResultadoVelocidade.text = texto
                    }
                    1 -> {
                        var texto = "Quilometros/Hora = "
                        texto += valor.toDouble() * 3.6f
                        texto += " m/s \nMilhas/Hora = "
                        texto += valor.toDouble() * 2.2369f
                        texto += " mph"
                        txtResultadoVelocidade.text = texto
                    }
                    2 -> {
                        var texto = "Quilometros/Hora = "
                        texto += valor.toDouble() * 1.609
                        texto += " Km/h \nMetros/Segundo = "
                        texto += valor.toDouble() / 2.2369f
                        texto += " m/s"
                        txtResultadoVelocidade.text = texto
                    }
                }

            } else {
                txtResultadoVelocidade.text = "Adicione um valor para converter"
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


