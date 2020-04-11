package com.threed.printmatcher.features.volunteer.submissions.mvp

import com.threed.printmatcher.features.di.FragmentScope
import com.threed.printmatcher.model.Submission
import javax.inject.Inject

@FragmentScope
class VolunteerSubmissionsPresenter @Inject constructor() : VolunteerSubmissionsContract.Presenter {

    private lateinit var view: VolunteerSubmissionsContract.View

    override fun onViewAvailable(view: VolunteerSubmissionsContract.View) {
        this.view = view
    }

    override fun onSubmissionItemClicked(item: Submission) {
        view.navigateToSubmissionDetails(item)
    }
}