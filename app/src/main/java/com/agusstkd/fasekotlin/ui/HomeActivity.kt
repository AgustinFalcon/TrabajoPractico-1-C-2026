package com.agusstkd.fasekotlin.ui

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.agusstkd.fasekotlin.model.Persona
import com.agusstkd.fasekotlin.R
import com.agusstkd.fasekotlin.databinding.ActivityHomeBinding
import com.google.android.material.navigation.NavigationView
import com.google.gson.Gson

class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawerLayout: DrawerLayout

    private lateinit var navController: NavController

    private lateinit var binding: ActivityHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar: Toolbar = binding.toolBar
        setSupportActionBar(toolbar)

        drawerLayout = binding.drawerLayout
        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.open_drawer_layout,
            R.string.close_drawer_layout
        )

        drawerLayout.addDrawerListener(toggle)


        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu_burguer)


        binding.navigationView.setNavigationItemSelectedListener(this)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment

        /*if (savedInstanceState == null) {
            replaceFragment(ListFragment())
            binding.navigationView.setCheckedItem(R.id.nav_item_one)
        }*/

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START)

                } else {
                    Toast.makeText(this@HomeActivity, "No puede salir con back", Toast.LENGTH_SHORT).show()
                }
            }
        })

        navController = navHostFragment.navController

        //val name = intent.getStringExtra("name")
        //val user = intent.getSerializableExtra("persona") as Persona
        val preferences = getSharedPreferences(RegisterActivity.Companion.CREDENCIALES, MODE_PRIVATE)
        val gson = Gson()
        val personaInJsonFormat = preferences.getString("persona", null)
        val persona = gson.fromJson(personaInJsonFormat, Persona::class.java)
        //val name = preferences.getString("name", "")
        //val pass = preferences.getInt("password", 0)


        //binding.textViewName.text = "Bienvenido ${persona.name}, su pass es: ${persona.pass}"

        /*binding.btnClearData.setOnClickListener {
            preferences.edit().clear().apply()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }*/
    }

    private fun replaceFragment(fragment: Fragment) {
        val transition = supportFragmentManager.beginTransaction()
        //transition.replace(R.id.fragmentContainerView, fragment)
        transition.commit()
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.nav_item_one -> {
                //replaceFragment(ListFragment())
                navController.navigate(R.id.listFragment)
                Toast.makeText(this, "Opcion 1", Toast.LENGTH_SHORT).show()
            }

            R.id.nav_item_two -> {
                //replaceFragment(SecondFragment())
                navController.navigate(R.id.secondFragment)
                Toast.makeText(this, "Opcion 2", Toast.LENGTH_SHORT).show()
            }

            R.id.nav_item_three -> {
                //replaceFragment(ThirdFragment())
                navController.navigate(R.id.thirdFragment)
                Toast.makeText(this, "Opcion 3", Toast.LENGTH_SHORT).show()
            }
        }

        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}