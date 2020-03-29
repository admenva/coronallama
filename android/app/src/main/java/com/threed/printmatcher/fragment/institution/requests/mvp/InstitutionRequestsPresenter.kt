package com.threed.printmatcher.fragment.institution.requests.mvp

import com.threed.printmatcher.fragment.di.FragmentScope
import com.threed.printmatcher.model.Submission
import javax.inject.Inject

@FragmentScope
class InstitutionRequestsPresenter @Inject constructor() :
    InstitutionRequestsContract.Presenter {

    private lateinit var mView: InstitutionRequestsContract.View

    override fun onViewAvailable(view: InstitutionRequestsContract.View) {
        mView = view
    }

    override fun onSubmissionItemClicked(item: Submission) {
        mView.navigateToSubmissionDetails(item)
    }
}