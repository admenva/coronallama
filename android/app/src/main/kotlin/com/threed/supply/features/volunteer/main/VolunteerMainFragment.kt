package com.threed.supply.features.volunteer.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.threed.supply.R
import com.threed.supply.app.activity.main.AppViewModel
import com.threed.supply.libs.model.User.Volunteer
import dagger.android.support.DaggerFragment

class VolunteerMainFragment : DaggerFragment() {

    private val appViewModel: AppViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_volunteer_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        appViewModel.setUser(
            Volunteer(
                "3D Shield Printer",
                "Face Shield Printing",
                "shield3D@gmail.com",
                "1 Portland House, London, United Kingdom"
            )
        )
    }
}


