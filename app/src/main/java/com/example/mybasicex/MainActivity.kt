package com.example.mybasicex

import android.os.Bundle
import android.util.TypedValue
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.mybasicex.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        //Asignar titulo a la aplicacion
        //supportActionBar?.title = "Youtube"


        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.buttomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.plus -> {
                    findNavController(R.id.nav_host_fragment_content_main).navigate(R.id.action_fg_recycler_ex_to_fg_form_ex)

                }
                R.id.shortt -> Toast.makeText(this, "Pulsaste Shorts", Toast.LENGTH_LONG).show()
                R.id.suscripcion -> Toast.makeText(this, "Pulsaste Suscripcion", Toast.LENGTH_LONG).show()
                R.id.tu -> Toast.makeText(this, "Pulsaste Tu", Toast.LENGTH_LONG).show()
                else -> {
                    Toast.makeText(this, "Pulsa otro boton", Toast.LENGTH_LONG).show()
                }
            }
            true
        }

        /*
        binding.btnEnviar.setOnClickListener { view ->
            val currentDestinationId = findNavController(R.id.nav_host_fragment_content_main).currentDestination?.id

            // Verifica el fragmento actual y realiza la acción correspondiente
            when (currentDestinationId) {
                R.id.FirstFragment -> {
                    findNavController(R.id.nav_host_fragment_content_main).navigate(R.id.action_FirstFragment_to_fg_recycler_ex)
                }
                R.id.SecondFragment -> {
                    findNavController(R.id.nav_host_fragment_content_main).navigate(R.id.action_SecondFragment_to_fg_recycler_ex)

                }
                R.id.fg_recycler_ex -> {
                    findNavController(R.id.nav_host_fragment_content_main).navigate(R.id.action_fg_recycler_ex_to_fg_form_ex)

                }
                R.id.fg_form_ex -> {
                    findNavController(R.id.nav_host_fragment_content_main).navigate(R.id.action_fg_form_ex_to_fg_recycler_ex)

                }
                else -> {
                    Snackbar.make(view, "Pulsa otro boton", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show()
                }
            }
        }*/
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.custom_bar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.Search -> {
                Toast.makeText(this, "Pulsaste en el boton buscar", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.notification -> {
                Toast.makeText(this, "Pulsaste en el boton de notificacion", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.transmitir -> {
                Toast.makeText(this, "Pulsaste en el boton de notificacion", Toast.LENGTH_LONG).show()
                //Snackbar.make(view, "Pulsa otro boton", Snackbar.LENGTH_LONG)
                //                        .setAction("Action", null).show()
                return true
            }
            R.id.Config -> {
                Toast.makeText(this, "Pulsaste Config", Toast.LENGTH_LONG).show()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}