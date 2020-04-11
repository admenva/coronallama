package com.threed.printmatcher.features.institution.create.mvp

import com.threed.printmatcher.features.di.FragmentScope
import com.threed.printmatcher.model.Request
import javax.inject.Inject

@FragmentScope
class NewRequestPresenter @Inject constructor(
) : NewRequestContract.Presenter {

    private lateinit var view: NewRequestContract.View

    override fun onViewAvailable(view: NewRequestContract.View) {
        this.view = view
    }

    override fun onCreateButtonClicked(item: Request) {
        view.navigateToRequestsPage(item)
    }
}