package com.threed.printmatcher.features.institution.requests.mvp

import com.threed.printmatcher.features.di.FragmentScope
import com.threed.printmatcher.model.Request
import javax.inject.Inject

@FragmentScope
class InstitutionRequestsPresenter @Inject constructor() :
    InstitutionRequestsContract.Presenter {

    private lateinit var view: InstitutionRequestsContract.View

    override fun onViewAvailable(view: InstitutionRequestsContract.View) {
        this.view = view
    }

    override fun onRequestItemClicked(item: Request) {
        //TODO mView.navigateToRequestDetails(item)
    }

    override fun onAddRequestButtonClicked() {
        view.navigateToCreateRequestPage()
    }
}