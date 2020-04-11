package com.threed.supply.features.volunteer.submissions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.threed.supply.R
import com.threed.supply.features.volunteer.submissions.mvp.VolunteerSubmissionsContract
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class VolunteerSubmissionsFragment : DaggerFragment() {

    @Inject
    lateinit var presenter: VolunteerSubmissionsContract.Presenter
    @Inject
    lateinit var view: VolunteerSubmissionsContract.View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val pageLayout = inflater.inflate(R.layout.fragment_volunteer_submissions, container, false)
        view.bind(pageLayout)
        presenter.onViewAvailable(view)
        return pageLayout
    }
}