package ar.edu.ifts18.saludopersonalizado

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ar.edu.ifts18.saludopersonalizado.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val prefs = getSharedPreferences("mi_app", Context.MODE_PRIVATE)
        var nombreGuardado: String? = null
        var saludoPersonalizado = findViewById<TextView>(R.id.textoBienvenida)
        var ingresarTexto = findViewById<EditText>(R.id.textoEditable)
        var guardarNombre = findViewById<Button>(R.id.botonGuardar)
        nombreGuardado = prefs.getString("nombre", null)
        if (nombreGuardado != null) {
            saludoPersonalizado.text = "Hola, $nombreGuardado"
            ingresarTexto.visibility = android.view.View.GONE
            guardarNombre.visibility = android.view.View.GONE

        }
        else {
            saludoPersonalizado.text = "Por favor ingresá tu nombre"
        }




            guardarNombre.setOnClickListener {
                var nombreNuevo = ingresarTexto.text.toString()
                if(nombreNuevo.isNotBlank()){
                    prefs.edit().putString("nombre", nombreNuevo).apply()
                }
                nombreGuardado = prefs.getString("nombre", null)
                saludoPersonalizado.text = "Hola, $nombreGuardado"

            }
        }
    }

