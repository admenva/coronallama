package com.threed.printmatcher.fragment.submissions.volunteer.mvp

import com.threed.printmatcher.fragment.di.FragmentScope
import com.threed.printmatcher.model.Submission
import javax.inject.Inject

@FragmentScope
class VolunteerSubmissionsPresenter @Inject constructor() : VolunteerSubmissionsContract.Presenter {

    private lateinit var mView: VolunteerSubmissionsContract.View

    override fun onViewAvailable(view: VolunteerSubmissionsContract.View) {
        mView = view
    }

    override fun onSubmissionItemClicked(item: Submission) {
        mView.navigateToSubmissionDetails(item)
    }
}