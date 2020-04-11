package com.threed.supply.features.volunteer.request.confirmation.mvp

import com.threed.supply.features.di.FragmentScope
import com.threed.supply.libs.model.Submission
import com.threed.supply.libs.model.User.*
import javax.inject.Inject

@FragmentScope
class RequestConfirmationPresenter @Inject constructor(
    private val submission: Submission,
    private val user: Volunteer
) : RequestConfirmationContract.Presenter {

    private lateinit var view: RequestConfirmationContract.View

    override fun onViewAvailable(view: RequestConfirmationContract.View) {
        this.view = view
    }

    override fun onResume() {
        view.loadImage(submission.request.imageResource)
        view.fillTitle(submission.request.title)
        view.fillSubtitle(submission.request.hospitalName)
        view.fillCommittedQuantity(submission.committedQuantity)
        view.fillInstitutionAddress(submission.request.location)
        view.fillUserName(user.name)
        view.fillUserContact(user.email)
        view.fillUserLocation(user.address)
    }

    override fun onSubmitButtonClicked() {
        view.navigateToSubmissionsListPage()
    }
}