package com.threed.printmatcher.fragment.institution.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.threed.printmatcher.R
import com.threed.printmatcher.activity.main.AppViewModel
import com.threed.printmatcher.model.User.Institution
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
                "St Thomas' Hospital",
                "#425678",
                "stlondonhospital@gmail.com",
                "Westminster Bridge Rd, London"
            )
        )
    }
}


