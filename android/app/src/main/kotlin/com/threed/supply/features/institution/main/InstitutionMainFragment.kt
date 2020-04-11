package com.threed.supply.features.institution.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.threed.supply.R
import com.threed.supply.app.activity.main.AppViewModel
import com.threed.supply.libs.model.User.Institution
import dagger.android.support.DaggerFragment

class InstitutionMainFragment : DaggerFragment() {

    private val appViewModel: AppViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_institution_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        appViewModel.setUser(
            Institution(
                "#425678",
                "St Thomas' Hospital",
                "sthospital@gmail.com",
                "Westminster Bridge Rd, London"
            )
        )
    }
}


