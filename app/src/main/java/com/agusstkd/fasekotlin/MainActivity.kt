package com.agusstkd.fasekotlin

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
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
                validateUser(name, password)

            } else {
                Toast.makeText(this, "Escribi algo", Toast.LENGTH_SHORT).show()
            }
        }

        binding.buttonRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        checkAutoLogin()
    }

    private fun checkAutoLogin() {
        val preferences = getSharedPreferences(RegisterActivity.CREDENCIALES, MODE_PRIVATE)
        val autoLogin = preferences.getBoolean("autoLogin", false)
        if (autoLogin) {
            navigateToHome()
        }
    }

    fun validateUser(name: String, password: String) {
        try {
            val preferences = getSharedPreferences(RegisterActivity.CREDENCIALES, MODE_PRIVATE)
            val gson = Gson()

            val personInJsonFormat = preferences.getString("persona", null)
            val persona = gson.fromJson(personInJsonFormat, Persona::class.java)

            if (persona.name == name && persona.pass == password) {
                val editor = preferences.edit()

                editor.putBoolean("autoLogin", binding.checkboxSession.isChecked)
                editor.apply()
                navigateToHome()

            } else {
                Toast.makeText(this, "Alguno de los campos es incorrecto", Toast.LENGTH_SHORT).show()
            }

        } catch (e: Exception) {
            Toast.makeText(this, "Usuario not exist", Toast.LENGTH_SHORT).show()
            Log.d("LoginError", "Error buscar usuario: ${e.message}")
        }
    }


    private fun navigateToHome() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
}
