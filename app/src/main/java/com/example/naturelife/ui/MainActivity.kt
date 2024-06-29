package com.example.naturelife.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.naturelife.R
import com.example.naturelife.services.TrackingService
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.yandex.mapkit.MapKitFactory
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MapKitFactory.initialize(this)
        setContentView(R.layout.activity_main)

        navigateToMapFragmentFromOutside(intent)

        setupBottomNavigation()
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        navigateToMapFragmentFromOutside(intent)
    }

    private fun setupBottomNavigation() {
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        findViewById<BottomNavigationView>(R.id.bottom_nav)
            .setupWithNavController(navController)
    }

    private fun navigateToMapFragmentFromOutside(intent: Intent?) {
        if (intent?.action == TrackingService.ACTION_SHOW_MAP_FRAGMENT) {
            navHostFragment.findNavController().navigate(R.id.actionGlobalMapFragment)
        }
    }
}