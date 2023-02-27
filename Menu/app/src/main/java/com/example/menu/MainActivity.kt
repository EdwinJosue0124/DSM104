package com.example.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nombre=findViewById<EditText>(R.id.etNombre1)
        val nota1=findViewById<EditText>(R.id.etNota1)
        val nota2=findViewById<EditText>(R.id.etNota2)
        val nota3=findViewById<EditText>(R.id.etNota3)
        val nota4=findViewById<EditText>(R.id.etNota4)
        val btncalcular=findViewById<Button>(R.id.btnCalcular)
        val Mnombre= findViewById<TextView>(R.id.tvNombre)
        val MPromedio= findViewById<TextView>(R.id.tvPromedio)
        val MAprobo= findViewById<TextView>(R.id.tvAprobo)

        btncalcular.setOnClickListener{
            val suma=nota1.text.toString().toInt()+nota2.text.toString().toInt()+nota3.text.toString().toInt()+nota4.text.toString().toInt()
            val promedio=suma/4
            Mnombre.text="Nombre: ${nombre.text.toString()}"
            MPromedio.text="Promedio: ${promedio.toString()}"
            if(promedio >=5){
                MAprobo.text="Aprobo"
            }else{
                MAprobo.text="Reprobo"
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
        if(item.itemId == R.id.opcion3)
            startActivity(Intent(this,Ejercicio3::class.java))
                return super.onOptionsItemSelected(item)
    }



}