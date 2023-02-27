package com.example.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Ejercicio2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejercicio2)

        val nombre =findViewById<EditText>(R.id.etNombre1)
        val salario= findViewById<EditText>(R.id.etSalario)
        val Mnombre=findViewById<TextView>(R.id.tvNombre1)
        val salarioN =findViewById<TextView>(R.id.tvSalarioN)
        val btncalcular= findViewById<Button>(R.id.btnCalcular1)

        btncalcular.setOnClickListener{
            val descuentos= salario.text.toString().toDouble()*0.12
            val salarioNeto= salario.text.toString().toDouble()-descuentos
            Mnombre.text="Nombre: ${nombre.text.toString()}"
            salarioN.text="Salario Neto: ${salarioNeto.toString()}"
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
        if(item.itemId == R.id.opcion3)
            startActivity(Intent(this,Ejercicio3::class.java))
        return super.onOptionsItemSelected(item)
    }
}