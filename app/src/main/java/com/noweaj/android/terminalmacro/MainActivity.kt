package com.noweaj.android.terminalmacro

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.noweaj.android.terminalmacro.ui.dashboard.DashboardFragment
import com.noweaj.android.terminalmacro.ui.settings.SettingsFragment
import com.noweaj.android.terminalmacro.ui.terminal.TerminalFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
//        val navView: BottomNavigationView = findViewById(R.id.bnv_main)
//        val navController = findNavController(R.id.f_main)
//        
//        val appBarConfiguration = AppBarConfiguration(setOf(
//            R.id.fragment_dashboard, R.id.fragment_terminal, R.id.fragment_settings
//        ))
//        setupActionBarWithNavController(navController, appBarConfiguration)
//        navView.setupWithNavController(navController)
        
        val dashboard = DashboardFragment()
        val terminal = TerminalFragment()
        val settings = SettingsFragment()
        
        var current = Fragment()
        
        val bnv_main = findViewById<BottomNavigationView>(R.id.bnv_main)
        bnv_main.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.fragment_dashboard -> {
                    supportFragmentManager.beginTransaction()
                        .hide(current).show(dashboard).commit()
                    current = dashboard
                    true
                }
                R.id.fragment_terminal -> {
                    supportFragmentManager.beginTransaction()
                        .hide(current).show(terminal).commit()
                    current = terminal
                    true
                }
                R.id.fragment_settings -> {
                    supportFragmentManager.beginTransaction()
                        .hide(current).show(settings).commit()
                    current = settings
                    true
                }
                else -> false
            }
        }
        
        supportFragmentManager.beginTransaction()
            .add(R.id.fl_main, dashboard)
            .add(R.id.fl_main, terminal)
            .add(R.id.fl_main, settings).commit()
        
        supportFragmentManager.beginTransaction()
            .hide(dashboard).hide(terminal).hide(settings).commit()
        
        supportFragmentManager.beginTransaction()
            .show(dashboard).commit()
        current = dashboard
    }
}