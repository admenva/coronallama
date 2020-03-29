package com.threed.printmatcher.fragment.volunteer.submissions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.threed.printmatcher.R
import com.threed.printmatcher.fragment.volunteer.submissions.mvp.VolunteerSubmissionsContract
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class VolunteerSubmissionsFragment : DaggerFragment() {

    @Inject
    lateinit var mPresenter: VolunteerSubmissionsContract.Presenter
    @Inject
    lateinit var mView: VolunteerSubmissionsContract.View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val pageLayout = inflater.inflate(R.layout.fragment_volunteer_submissions, container, false)
        mView.bind(pageLayout)
        mPresenter.onViewAvailable(mView)
        return pageLayout
    }
}