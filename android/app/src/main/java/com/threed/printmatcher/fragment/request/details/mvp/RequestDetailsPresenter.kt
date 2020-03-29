package com.threed.printmatcher.fragment.request.details.mvp

import com.threed.printmatcher.R
import com.threed.printmatcher.fragment.di.FragmentScope
import com.threed.printmatcher.model.Request
import com.threed.printmatcher.model.State
import com.threed.printmatcher.model.Submission
import com.threed.printmatcher.util.DateCreator
import com.threed.printmatcher.util.ToastManager
import javax.inject.Inject

@FragmentScope
class RequestDetailsPresenter @Inject constructor(
    private val request: Request,
    private val toastManager: ToastManager,
    private val dateCreator: DateCreator
) : RequestDetailsContract.Presenter {

    private lateinit var mView: RequestDetailsContract.View

    override fun onViewAvailable(view: RequestDetailsContract.View) {
        mView = view
    }

    override fun onResume() {
        mView.showHospitalImage(request.imageResource)
        mView.showTitle(request.title)
        mView.showDescription(request.description)
        mView.showNeeds(request.requested)
        mView.showLocation(request.location)
        mView.showMapImage()
        mView.setupCommittedQuantitySection()
    }

    override fun onOkButtonClicked(committedQuantity: Int) {
        if (committedQuantity > request.requested) {
            toastManager.show(R.string.error_quantity_overflown)
        } else {
            mView.navigateToRequestConfirmation(
                Submission(
                    request,
                    State.PENDING,
                    committedQuantity,
                    dateCreator.createDate(2020, 4, 16)
                )
            )
        }
    }
}