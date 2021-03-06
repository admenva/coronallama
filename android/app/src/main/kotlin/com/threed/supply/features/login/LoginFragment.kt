package com.threed.supply.features.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.view.ViewCompat.requireViewById
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.threed.supply.R
import com.threed.supply.libs.model.UserType
import dagger.android.support.DaggerFragment

class LoginFragment : DaggerFragment() {

    private val args: LoginFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        requireViewById<Button>(view, R.id.login_btn)
            .setOnClickListener { navigateToHome() }
        requireViewById<TextView>(view, R.id.signup_btn)
            .setOnClickListener { navigateToSignUp() }

        return view
    }

    private fun navigateToSignUp() {
        findNavController().navigate(LoginFragmentDirections.loginToSignup(UserType.VOLUNTEER))
    }

    private fun navigateToHome() {
        when (args.userType) {
            UserType.VOLUNTEER -> findNavController().navigate(LoginFragmentDirections.loginToVolunteer())
            UserType.INSTITUTION -> findNavController().navigate(LoginFragmentDirections.loginToInstitution())
        }
    }
}