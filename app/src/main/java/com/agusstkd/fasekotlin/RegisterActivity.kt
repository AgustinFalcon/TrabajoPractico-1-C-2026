package com.agusstkd.fasekotlin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.agusstkd.fasekotlin.databinding.RegisterMainBinding
import com.google.gson.Gson

class RegisterActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var binding: RegisterMainBinding

    val arrayColors: Array<Colors> = Colors.values()

    var colorSelected: Colors? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RegisterMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("PruebaCiclosdeVida", "onCreate()")
        binding.tvTitleSpinnerColors.text = "Seleccione un sexo"

        val adapter = ArrayAdapter(this, R.layout.my_simple_spinner_item, arrayColors)
        binding.spinnerColors.adapter = adapter
        binding.spinnerColors.onItemSelectedListener = this

        binding.btnRegister.setOnClickListener {
            savePerson()
        }

        /*binding.spinnerColors.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                if (arrayColors.get(position) != Colors.SELECCIONE_UN_DATO) {
                    colorSelected = arrayColors.get(position)
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                colorSelected = null
            }
        }*/
    }

    fun savePerson() {
        val name = binding.etName.text.toString()
        val password = binding.etPassword.text.toString()

        if (name.isNotEmpty() && password.length >= 3 && colorSelected != null) {
            val preferences = getSharedPreferences(CREDENCIALES, MODE_PRIVATE)
            val edit = preferences.edit()

            val persona = Persona(name = name, pass = password, color = colorSelected!!)
            val gson = Gson()

            val personInJsonFormat = gson.toJson(persona)
            edit.putString("persona", personInJsonFormat)

            edit.apply()
            goToMainActivity()

        } else {
            Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()
        }
    }

    private fun goToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        //finish()
    }

    // SPINNER INTERFACES
    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
        Toast.makeText(this, arrayColors.get(position).toString(), Toast.LENGTH_SHORT).show()
        Log.d("Prueba Spinner", arrayColors.get(position).toString())
        if (arrayColors.get(position) != Colors.SELECCIONE_UN_DATO) {
            colorSelected = arrayColors.get(position)
        } else {
            colorSelected = null
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        Toast.makeText(this, "onNothingSelected", Toast.LENGTH_SHORT).show()
    }

    /*override fun onItemClick(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
        Toast.makeText(this, arrayColors.get(position).toString(), Toast.LENGTH_SHORT).show()
        Log.d("Prueba Spinner", arrayColors.get(position).toString())
    }*/

    companion object {
        const val CREDENCIALES = "Credenciales"
    }


    override fun onStart() {
        super.onStart()
        Log.d("PruebaCiclosdeVida", "onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d("PruebaCiclosdeVida", "onResume()")
    }

    //// INTERACTUA EL USUARIO
    override fun onPause() {
        super.onPause()
        Log.d("PruebaCiclosdeVida", "onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d("PruebaCiclosdeVida", "onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("PruebaCiclosdeVida", "onDestroy()")
    }
}