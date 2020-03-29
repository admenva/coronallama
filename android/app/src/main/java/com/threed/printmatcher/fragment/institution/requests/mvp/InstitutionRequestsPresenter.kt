package com.threed.printmatcher.fragment.institution.requests.mvp

import com.threed.printmatcher.fragment.di.FragmentScope
import com.threed.printmatcher.model.Request
import javax.inject.Inject

@FragmentScope
class InstitutionRequestsPresenter @Inject constructor() :
    InstitutionRequestsContract.Presenter {

    private lateinit var mView: InstitutionRequestsContract.View

    override fun onViewAvailable(view: InstitutionRequestsContract.View) {
        mView = view
    }

    override fun onRequestItemClicked(item: Request) {
        //TODO mView.navigateToRequestDetails(item)
    }

    override fun onAddRequestButtonClicked() {
        //TODO mView.navigateToAddRequestPage(item)
    }
}