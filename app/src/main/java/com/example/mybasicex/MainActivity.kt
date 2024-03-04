package com.example.mybasicex

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.example.mybasicex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

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
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}