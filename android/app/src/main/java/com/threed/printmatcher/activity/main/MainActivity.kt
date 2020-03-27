package com.threed.printmatcher.activity.main

import android.os.Bundle
import com.threed.printmatcher.R
import com.threed.printmatcher.fragment.mainpage.MainPageFragment
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addInitialFragment()
    }

    private fun addInitialFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_holder, MainPageFragment(), "tag")
            .addToBackStack("tag")
            .commit()
    }
}