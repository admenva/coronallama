package com.threed.printmatcher.features.volunteer.request.confirmation.mvp

import com.threed.printmatcher.features.di.FragmentScope
import com.threed.printmatcher.model.Submission
import com.threed.printmatcher.model.User.*
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