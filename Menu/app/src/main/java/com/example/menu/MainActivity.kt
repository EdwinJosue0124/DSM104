package com.example.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {

    private val db=FirebaseFirestore.getInstance()

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
        val btnmostrar=findViewById<Button>(R.id.btnRecuperar)
        val btnborrar=findViewById<Button>(R.id.btnBorrar)



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
           db.collection("alumnos").document(nombre.text.toString()).set(
               hashMapOf("nota1" to nota1.text.toString(),
                   "nota2" to nota2.text.toString(),
                   "nota3" to nota3.text.toString(),
                   "nota4" to nota4.text.toString(),
                   "promedio" to MPromedio,
                   "pasoOno" to MAprobo)
           )

        }

        btnmostrar.setOnClickListener {
            db.collection("alumnos").document(nombre.text.toString()).get().addOnSuccessListener{
                Mnombre.setText(it.get("nombre")as String?)
                nota1.setText(it.get("nota1")as String?)
                nota2.setText(it.get("nota2")as String?)
                nota3.setText(it.get("nota3")as String?)
                nota4.setText(it.get("nota4")as String?)
                MPromedio.setText(it.get("promedio")as String?)
                MAprobo.setText(it.get("pasoOno")as String?)
            }
        }

        btnborrar.setOnClickListener {
            db.collection("alumnos").document(nombre.text.toString()).delete()
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