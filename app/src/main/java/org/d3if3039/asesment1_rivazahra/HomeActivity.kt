package org.d3if3039.asesment1_rivazahra

import android.app.AlertDialog
import android.content.DialogInterface
import android.net.ConnectivityManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.d3if3039.asesment1_rivazahra.R
import org.d3if3039.asesment1_rivazahra.databinding.ActivityHomeBinding
import org.d3if3039.asesment1_rivazahra.databinding.ActivityMainBinding

class HomeActivity : AppCompatActivity() {

    companion object{
        const val CHANNEL_ID = "update"
        const val PERMISSION_REQUEST_CODE = 1
    }
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView
         navController = findNavController(R.id.nav_host_fragment_activity_main)
        NavigationUI.setupActionBarWithNavController(this,navController)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.fragmentAdd, R.id.fragmentSearch, R.id.historyFragment
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }


}