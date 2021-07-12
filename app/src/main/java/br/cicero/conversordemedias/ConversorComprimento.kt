package br.cicero.conversordemedias

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import java.math.BigDecimal

class ConversorComprimento : AppCompatActivity() {

    var unidades = arrayOf("Milimetro(mm)", "Centimetro(cm)", "Metro(m)", "Quilometro(Km)")
    var selecao = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversor_comprimento)

        //Carregar Componentes
        val spinner = findViewById<Spinner>(R.id.spinnerComprimento)
        val txtResultado = findViewById<TextView>(R.id.txtResultadoComprimento)
        val editNumberComprimento = findViewById<EditText>(R.id.editTextNumberComprimento)
        val btnCalcularComprimento = findViewById<Button>(R.id.btnCalcularComprimento)

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
        btnCalcularComprimento.setOnClickListener {
            val valor = editNumberComprimento.text.toString()

            if (valor != "") {
                when (selecao) {

                    0 -> {
                        var texto = "centimetro = "
                        texto += valor.toDouble() / 10.0
                        texto += " cm \nMetro = "
                        texto += valor.toDouble() / 1000.0
                        texto += " m \nQuilometro = "
                        texto += valor.toDouble() / 1000000.0
                        texto += " km"
                        txtResultado.text = texto
                    }

                    1 -> {
                        var texto = "Milimetro = "
                        texto += valor.toDouble() * 10.0
                        texto += " mm \nMetro = "
                        texto += valor.toDouble() / 1000.0
                        texto += " m \nQuilometro = "
                        texto += valor.toDouble() / 1000000.0
                        texto += " km"
                        txtResultado.text = texto
                    }

                    2 -> {
                        var texto = " Milimetro = "
                        texto += valor.toDouble() * 1000.0
                        texto += " mm \nCentrimetro = "
                        texto += valor.toDouble() * 100.0
                        texto += " m \nQuilometro = "
                        texto += valor.toDouble() / 1000.0
                        texto += " km"
                        txtResultado.text = texto
                    }

                    3 -> {
                        var texto = "Milimetro = "
                        texto += valor.toDouble() * 1000000.0
                        texto += " mm \nCentrimetro = "
                        texto += valor.toDouble() * 100000.0
                        texto += " m \nmetro = "
                        texto += valor.toDouble() * 1000.0
                        texto += " km"
                        txtResultado.text = texto
                    }
                }
            } else {
                txtResultado.text = "Adicione um valor para converter"
            }
        }
        //Ativar o  up navegation na actionbar
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

