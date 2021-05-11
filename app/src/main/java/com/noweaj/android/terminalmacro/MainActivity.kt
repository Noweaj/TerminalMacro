package com.noweaj.android.terminalmacro

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val navView: BottomNavigationView = findViewById(R.id.bnv_main)
        val navController = findNavController(R.id.f_main)
        
        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.fragment_dashboard, R.id.fragment_terminal, R.id.fragment_settings
        ))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}