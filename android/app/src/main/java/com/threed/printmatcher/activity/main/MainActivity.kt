package com.threed.printmatcher.activity.main

import android.os.Bundle
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
import com.threed.printmatcher.model.User
import com.threed.printmatcher.model.User.Institution
import com.threed.printmatcher.model.User.Volunteer
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.drawer_header.view.*

class MainActivity : DaggerAppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private val viewModel: AppViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val view = binding.root

        with(viewModel) {
            getUser().observe((this@MainActivity), Observer { user: User ->
                val toolbar: Toolbar = findViewById(R.id.toolbar)
                setSupportActionBar(toolbar)

                val drawerLayout = view.findViewById<DrawerLayout>(R.id.drawer_layout)
                val navView = view.findViewById<NavigationView>(R.id.nav_view)
                val headerView = navView.getHeaderView(0)
                val navController = findNavController(R.id.main_nav_host)

                when (user) {
                    is Institution -> {
                        headerView.name.text = user.name
                        headerView.description.text = user.id
                        headerView.profile_img.setImageResource(R.drawable.ic_hospital)
                        appBarConfiguration = AppBarConfiguration(
                            setOf(
                                R.id.institution_requests_fragment,
                                R.id.volunteer_messages_fragment
                            ),
                            drawerLayout
                        )
                    }
                    is Volunteer -> {
                        headerView.name.text = user.name
                        headerView.description.text = user.description
                        headerView.profile_img.setImageResource(R.drawable.ic_3d_printer)
                        appBarConfiguration = AppBarConfiguration(
                            setOf(
                                R.id.volunteer_home_fragment,
                                R.id.volunteer_submissions_fragment,
                                R.id.volunteer_messages_fragment
                            ),
                            drawerLayout
                        )
                    }
                }

                setupActionBarWithNavController(navController, appBarConfiguration)
                navView.setupWithNavController(navController)
            })
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.main_nav_host)
        return navController.navigateUp(appBarConfiguration)
    }
}