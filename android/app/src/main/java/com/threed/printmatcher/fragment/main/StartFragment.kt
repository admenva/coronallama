package com.threed.printmatcher.fragment.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.view.ViewCompat.requireViewById
import androidx.navigation.findNavController
import com.threed.printmatcher.R
import com.threed.printmatcher.model.UserType
import com.threed.printmatcher.model.UserType.INSTITUTION
import com.threed.printmatcher.model.UserType.VOLUNTEER
import dagger.android.support.DaggerFragment

class StartFragment : DaggerFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_start, container, false)

        requireViewById<Button>(view, R.id.volunteer)
            .setOnClickListener { navigateToLogin(VOLUNTEER, view) }
        requireViewById<Button>(view, R.id.institution)
            .setOnClickListener { navigateToLogin(INSTITUTION, view) }

        return view
    }

    private fun navigateToLogin(user: UserType, view: View) {
        view.findNavController().navigate(StartFragmentDirections.startToLogin(user))
    }
}