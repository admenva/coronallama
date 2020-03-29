package com.threed.printmatcher.fragment.signup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.view.ViewCompat.requireViewById
import androidx.navigation.findNavController
import com.threed.printmatcher.R
import dagger.android.support.DaggerFragment

class SignUpFragment : DaggerFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_signup, container, false)
        requireViewById<Button>(view, R.id.signup_btn)
            .setOnClickListener { navigateToVolunteerHome(view) }
        return view
    }

    private fun navigateToVolunteerHome(view: View) {
        view.findNavController().navigate(SignUpFragmentDirections.signupToVolunteerHome())
    }
}