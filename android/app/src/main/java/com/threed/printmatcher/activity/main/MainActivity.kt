package com.threed.printmatcher.activity.main

import android.os.Bundle
import android.view.Menu
import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil.setContentView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.threed.printmatcher.R
import com.threed.printmatcher.databinding.ActivityMainBinding
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private val viewModel: AppViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val view = binding.root

        with(viewModel) {
            getUser().observe((this@MainActivity), Observer {
                val toolbar: Toolbar = findViewById(R.id.toolbar)
                setSupportActionBar(toolbar)

                val drawerLayout: DrawerLayout = view.findViewById(R.id.drawer_layout)
                val navView: NavigationView = view.findViewById(R.id.nav_view)
                val navController = findNavController(R.id.home_nav_host_fragment)
                // Passing each menu ID as a set of Ids because each
                // menu should be considered as top level destinations.
                appBarConfiguration = AppBarConfiguration(
                    setOf(R.id.volunteer_home_fragment),
                    drawerLayout
                )
                setupActionBarWithNavController(navController, appBarConfiguration)
                navView.setupWithNavController(navController)

            })
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.home_nav_host_fragment)
        return navController.navigateUp(appBarConfiguration)
    }
}