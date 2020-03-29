package com.threed.printmatcher.fragment.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.ViewCompat.requireViewById
import androidx.navigation.findNavController
import com.threed.printmatcher.R
import com.threed.printmatcher.fragment.types.UserType
import dagger.android.support.DaggerFragment

class LoginFragment : DaggerFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        requireViewById<TextView>(view, R.id.signup_btn)
            .setOnClickListener { navigateToSignUp(view) }
        return view
    }

    private fun navigateToSignUp(view: View) {
        view.findNavController().navigate(LoginFragmentDirections.loginToSignup(UserType.VOLUNTEER))
    }
}