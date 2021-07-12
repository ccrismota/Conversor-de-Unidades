package br.cicero.conversordemedias

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.*



class ConversorTempo : AppCompatActivity() {

    var unidades = arrayOf("Hora (h)", "Minutos(min)", "Segundos(s)")
    var selecao = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversor_tempo)


        //Carregar Componentes

        val spinner = findViewById<Spinner>(R.id.spinnerTempo)
        val txtResultadoTempo = findViewById<TextView>(R.id.txtResultadoTempo)
        val txtEditNumber = findViewById<TextView>(R.id.editTextNumberTempo)
        val btnCalcularTempo = findViewById<Button>(R.id.btnTempo)

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
        btnCalcularTempo.setOnClickListener(){
            val valor = txtEditNumber.text.toString()

            if (valor != "") {

                when (selecao) {

                    0 -> {
                        var texto = "Minutos = "
                        texto += valor.toDouble() / 60f
                        texto += " min \nSegundos = "
                        texto += valor.toDouble() * 3600f
                        texto += " s"
                        txtResultadoTempo.text = texto
                    }
                    1 -> {
                        var texto = "Hora = "
                        texto += valor.toDouble() /60f
                        texto += " h \nSegundos = "
                        texto += valor.toDouble() * 60f
                        texto += " s"
                        txtResultadoTempo.text = texto
                    }

                    2 -> {
                        var texto = "Hora = "
                        texto += valor.toDouble() /3600f
                        texto += " h \nMinutos = "
                        texto += valor.toDouble() /60f
                        texto += " min"
                        txtResultadoTempo.text = texto
                    }
                }

            } else {
                txtResultadoTempo.text = getString(R.string.Adicione_um_valor)
            }
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)

    }
}