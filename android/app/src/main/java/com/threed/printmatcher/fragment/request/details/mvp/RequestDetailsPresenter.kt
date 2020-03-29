package com.threed.printmatcher.fragment.request.details.mvp

import com.threed.printmatcher.R
import com.threed.printmatcher.fragment.di.FragmentScope
import com.threed.printmatcher.model.Request
import com.threed.printmatcher.util.ToastManager
import javax.inject.Inject

@FragmentScope
class RequestDetailsPresenter @Inject constructor(
    private val request: Request,
    private val toastManager: ToastManager
) : RequestDetailsContract.Presenter {

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
        mView.setupCommittedQuantitySection()
    }

    override fun onOkButtonClicked(committedQuantity: Int) {
        if (committedQuantity > request.needs) {
            toastManager.show(R.string.error_quantity_overflown)
        } else {
            mView.navigateToRequestConfirmation(request, committedQuantity)
        }
    }
}