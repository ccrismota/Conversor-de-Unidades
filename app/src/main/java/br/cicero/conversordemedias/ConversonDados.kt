package br.cicero.conversordemedias

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.*

class ConversonDados : AppCompatActivity() {

    var unidades = arrayOf("Byte(B)","Quilobyte(kB)", "Megabyte(MB)", "Gigabyte(GB)")
    var selecao = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_converson_dados)

        //Carregar Componentes
        val spinner= findViewById<Spinner>(R.id.spinnerDados)
        val txtResultadoDados = findViewById<TextView>(R.id.txtResultadoDados)
        val editNumberDados = findViewById<TextView>(R.id.editTextNumberDados)
        val btnCalcularDados = findViewById<Button>(R.id.btnDados)

        //Criar Array Adapter
        val adapter =   ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,unidades)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?,view: View?,position: Int, id: Long) {
                selecao = position
            }
        }
        btnCalcularDados.setOnClickListener(){
            val valor = editNumberDados.text.toString()

            if(valor != "") {

                when (selecao){

                    0 -> { var texto = "Kilobyte = "
                        texto += valor.toDouble() / 1024f
                        texto += " kB \nMegabyte = "
                        texto += valor.toDouble() / 1048576f
                        texto += " MB \nGigabyte = "
                        texto += valor.toDouble() / 1073741824f
                        texto += " GB"
                        txtResultadoDados.text = texto }

                    1 -> { var texto = "Byte = "
                        texto += valor.toDouble() * 1024f
                        texto += " B \nMegabyte = "
                        texto += valor.toDouble() / 1024f
                        texto += " MB \nGigabyte = "
                        texto += valor.toDouble() / 1048576f
                        texto += " GB"
                        txtResultadoDados.text = texto }

                    2 -> {var texto = "Byte = "
                        texto += valor.toDouble() * 1048576f
                        texto += " B \nKilobyte = "
                        texto += valor.toDouble() * 1024f
                        texto += " kB \nGigabyte = "
                        texto += valor.toDouble() / 1024f
                        texto += " GB"
                        txtResultadoDados.text = texto }

                    3 -> {var texto = "Byte = "
                        texto += valor.toDouble() * 1073741824.0
                        texto += " B \nKilobyte = "
                        texto += valor.toDouble() * 1048576.0
                        texto += " kB \nMegabyte = "
                        texto += valor.toDouble() * 1024.0
                        texto += " MB"
                        txtResultadoDados.text = texto
                    }
                }

            } else {
                txtResultadoDados.text = "Adicione um valor para converter"
            }
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item?.itemId==android.R.id.home)
            finish()
        return true



        return super.onOptionsItemSelected(item)
    }
}