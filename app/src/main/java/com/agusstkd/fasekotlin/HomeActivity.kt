package com.agusstkd.fasekotlin

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.agusstkd.fasekotlin.databinding.ActivityHomeBinding
import com.google.gson.Gson

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val name = intent.getStringExtra("name")
        //val user = intent.getSerializableExtra("persona") as Persona

        val preferences = getSharedPreferences(RegisterActivity.CREDENCIALES, MODE_PRIVATE)
        val gson = Gson()

        val personaInJsonFormat = preferences.getString("persona", null)
        val persona = gson.fromJson(personaInJsonFormat, Persona::class.java)


        //val name = preferences.getString("name", "")
        //val pass = preferences.getInt("password", 0)


        binding.textViewName.text = "Bienvenido ${persona.name}, su pass es: ${persona.pass}"


        binding.btnClearData.setOnClickListener {
            preferences.edit().clear().apply()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
