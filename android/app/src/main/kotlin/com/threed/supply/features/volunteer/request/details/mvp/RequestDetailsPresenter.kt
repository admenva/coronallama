package com.threed.supply.features.volunteer.request.details.mvp

import com.threed.supply.R
import com.threed.supply.features.di.FragmentScope
import com.threed.supply.libs.model.Request
import com.threed.supply.libs.model.State
import com.threed.supply.libs.model.Submission
import com.threed.supply.libs.util.DateCreator
import com.threed.supply.libs.util.ToastManager
import javax.inject.Inject

@FragmentScope
class RequestDetailsPresenter @Inject constructor(
    private val request: Request,
    private val toastManager: ToastManager,
    private val dateCreator: DateCreator
) : RequestDetailsContract.Presenter {

    private lateinit var view: RequestDetailsContract.View

    override fun onViewAvailable(view: RequestDetailsContract.View) {
        this.view = view
    }

    override fun onResume() {
        view.showHospitalImage(request.imageResource)
        view.showTitle(request.title)
        view.showDescription(request.description)
        view.showNeeds(request.requested)
        view.showLocation(request.location)
        view.showMapImage()
        view.setupCommittedQuantitySection()
    }

    override fun onOkButtonClicked(committedQuantity: Int) {
        if (committedQuantity > request.requested) {
            toastManager.show(R.string.error_quantity_overflown)
        } else {
            view.navigateToRequestConfirmation(
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