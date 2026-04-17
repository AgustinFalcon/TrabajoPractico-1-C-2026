package com.agusstkd.fasekotlin

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.agusstkd.fasekotlin.databinding.ActivityMainBinding
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    //main
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_main) //inflar
        setContentView(binding.root)

        val editTextName = findViewById<EditText>(R.id.editTextName)
        val buttonNext = findViewById<Button>(R.id.buttonLogin)

        binding.buttonLogin.setOnClickListener { // lamda
            val name = binding.editTextName.text.toString()
            val password = binding.editTextPassword.text.toString()

            if (name.trim().isNotEmpty() && password.length >= 3) {
                //Toast.makeText(this, "Bienvenido $name", Toast.LENGTH_SHORT).show()
                createPersonIntoSharedPreferences(name = name, password = password)
                navigateToHome()

            } else {
                Toast.makeText(this, "Escribi algo", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun createPersonIntoSharedPreferences(name: String, password: String) {
        val preferences = getSharedPreferences("Credenciales", MODE_PRIVATE)
        val editor = preferences.edit()

        val persona = Persona(name = name, pass = password)
        val gson = Gson()

        val personInJsonFormat = gson.toJson(persona)

        editor.putString("persona", personInJsonFormat)
        //editor.putString("name", name)
        //editor.putInt("password", password.toInt())
        editor.apply()
    }

    private fun navigateToHome() {
        val intent = Intent(this, HomeActivity::class.java)
        val name = binding.editTextName.text.toString()
        val persona = Persona(name = name, pass = "123")
        intent.putExtra("persona", persona)
        startActivity(intent)
    }
}
