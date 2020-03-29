package com.threed.printmatcher.activity.main

import android.os.Bundle
import androidx.databinding.DataBindingUtil.setContentView
import com.threed.printmatcher.R
import com.threed.printmatcher.databinding.ActivityMainBinding
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }
}