package com.example.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Ejercicio3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio3)

        val numero1 =findViewById<EditText>(R.id.etNumero1)
        val numero2 =findViewById<EditText>(R.id.etNumero2)
        val btnsumar =findViewById<Button>(R.id.btnSumar)
        val btnres =findViewById<Button>(R.id.btnRestar)
        val btnmul =findViewById<Button>(R.id.btnMul)
        val btndiv =findViewById<Button>(R.id.btnDiv)
        val resultado =findViewById<TextView>(R.id.tvResultado)

        btnsumar.setOnClickListener{
            val suma=numero1.text.toString().toInt()+numero2.text.toString().toInt()
            resultado.text="Resultado: ${suma.toString()}"
        }
        btnres.setOnClickListener{
            val restar=numero1.text.toString().toInt()-numero2.text.toString().toInt()
            resultado.text="Resultado: ${restar.toString()}"
        }
        btnmul.setOnClickListener{
            val multiplicar=numero1.text.toString().toInt()*numero2.text.toString().toInt()
            resultado.text="Resultado: ${multiplicar.toString()}"
        }
        btndiv.setOnClickListener{
            if (numero2.text.toString().toInt()==0){
                resultado.text="Resultado: Nose puede dividir entre 0"
            }else{
                val restar=numero1.text.toString().toInt()/numero2.text.toString().toInt()
                resultado.text="Resultado: ${restar.toString()}"
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater=menuInflater
        inflater.inflate(R.menu.menu_muestra, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.opcion1)
            startActivity(Intent(this,MainActivity::class.java))
        if(item.itemId == R.id.opcion2)
            startActivity(Intent(this,Ejercicio2::class.java))

        return super.onOptionsItemSelected(item)
    }
}