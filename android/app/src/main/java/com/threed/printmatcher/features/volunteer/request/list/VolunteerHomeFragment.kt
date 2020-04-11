package com.threed.printmatcher.features.volunteer.request.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.threed.printmatcher.R
import com.threed.printmatcher.features.volunteer.request.list.mvp.VolunteerHomeContract
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class VolunteerHomeFragment : DaggerFragment() {

    @Inject
    lateinit var presenter: VolunteerHomeContract.Presenter
    @Inject
    lateinit var view: VolunteerHomeContract.View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val pageLayout = inflater.inflate(R.layout.fragment_volunteer_home, container, false)
        view.bind(pageLayout)
        presenter.onViewAvailable(view)
        return pageLayout
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }
}