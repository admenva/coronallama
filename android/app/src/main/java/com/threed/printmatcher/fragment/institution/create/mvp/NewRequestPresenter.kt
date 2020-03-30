package com.threed.printmatcher.fragment.institution.create.mvp

import com.threed.printmatcher.fragment.di.FragmentScope
import com.threed.printmatcher.model.Request
import javax.inject.Inject

@FragmentScope
class NewRequestPresenter @Inject constructor(
) : NewRequestContract.Presenter {

    private lateinit var mView: NewRequestContract.View

    override fun onViewAvailable(view: NewRequestContract.View) {
        mView = view
    }

    override fun onCreateButtonClicked(item: Request) {
        mView.navigateToRequestsPage(item)
    }
}