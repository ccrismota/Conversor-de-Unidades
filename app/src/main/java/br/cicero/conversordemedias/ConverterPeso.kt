package br.cicero.conversordemedias

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.*

class ConverterPeso : AppCompatActivity() {

    var unidades = arrayOf("Miligrama(mg)", "Centigrama(cg)", "Grama(g)", "Quilograma(Kg)")
    var selecao = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_converter_peso)

        //Carregar Componentes
        val spinner = findViewById<Spinner>(R.id.spinnerPeso)
        val txtResultado = findViewById<TextView>(R.id.txtReaultadoPeso)
        val editNumberPeso = findViewById<TextView>(R.id.editTextNumberPeso)
        val btnCalcularPeso = findViewById<Button>(R.id.btnPeso)

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
        btnCalcularPeso.setOnClickListener() {
            val valor = editNumberPeso.text.toString()

            if (valor != "") {
                when (selecao) {
                    0 -> {
                        var texto = "centigrama = "
                        texto += valor.toDouble() / 10.0
                        texto += " cg \nGrama = "
                        texto += valor.toDouble() / 1000.0
                        texto += " g \nQuilograma = "
                        texto += valor.toDouble() / 1000000.0
                        texto += " kg"
                        txtResultado.text = texto
                    }

                    1 -> {
                        var texto = "Miligrama = "
                        texto += valor.toDouble() * 10.0
                        texto += " mg \nGrama = "
                        texto += valor.toDouble() / 100.0
                        texto += " g \nQuilograma = "
                        texto += valor.toDouble() / 100000.0
                        texto += " kg"
                        txtResultado.text = texto
                    }

                    2 -> {
                        var texto = "Miligrama = "
                        texto += valor.toDouble() * 1000.0
                        texto += " mg \nCentigrama = "
                        texto += valor.toDouble() * 100.0
                        texto += " cg \nQuilograma = "
                        texto += valor.toDouble() / 1000.0
                        texto += " kg"
                        txtResultado.text = texto
                    }

                    3 -> {
                        var texto = "Miligrama = "
                        texto += valor.toDouble() * 1000000.0
                        texto += " mg \nCentigrama = "
                        texto += valor.toDouble() * 100000.0
                        texto += " cg \nGrama = "
                        texto += valor.toDouble() * 1000.0
                        texto += " km"
                        txtResultado.text = texto
                    }
                }
            } else {

                txtResultado.text = "Adicione um valor para converter"
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