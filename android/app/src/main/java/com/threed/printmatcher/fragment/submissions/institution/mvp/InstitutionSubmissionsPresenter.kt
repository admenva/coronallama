package com.threed.printmatcher.fragment.submissions.institution.mvp

import com.threed.printmatcher.fragment.di.FragmentScope
import com.threed.printmatcher.model.Submission
import javax.inject.Inject

@FragmentScope
class InstitutionSubmissionsPresenter @Inject constructor() :
    InstitutionSubmissionsContract.Presenter {

    private lateinit var mView: InstitutionSubmissionsContract.View

    override fun onViewAvailable(view: InstitutionSubmissionsContract.View) {
        mView = view
    }

    override fun onSubmissionItemClicked(item: Submission) {
        mView.navigateToSubmissionDetails(item)
    }
}