package com.threed.printmatcher.fragment.submissions.mvp

import com.threed.printmatcher.fragment.di.FragmentScope
import com.threed.printmatcher.model.Submission
import javax.inject.Inject

@FragmentScope
class SubmissionsPresenter @Inject constructor() : SubmissionsContract.Presenter {

    private lateinit var mView: SubmissionsContract.View

    override fun onViewAvailable(view: SubmissionsContract.View) {
        mView = view
    }

    override fun onSubmissionItemClicked(item: Submission) {
        mView.navigateToSubmissionDetails(item)
    }
}