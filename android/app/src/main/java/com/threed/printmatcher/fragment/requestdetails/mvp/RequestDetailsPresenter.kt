package com.threed.printmatcher.fragment.requestdetails.mvp

import com.threed.printmatcher.fragment.di.FragmentScope
import com.threed.printmatcher.model.Request
import javax.inject.Inject

@FragmentScope
class RequestDetailsPresenter @Inject constructor(private val request: Request) : RequestDetailsContract.Presenter {

    private lateinit var mView: RequestDetailsContract.View

    override fun onViewAvailable(view: RequestDetailsContract.View) {
        mView = view
    }

    override fun onResume() {
        mView.showHospitalImage(request.imageResource)
        mView.showTitle(request.title)
        mView.showDescription(request.description)
        mView.showNeeds(request.needs)
        mView.showLocation(request.location)
        mView.showMapImage()
        mView.setupCommitedQuantitySection(request.needs)
    }
}