package com.threed.printmatcher.fragment.volunteer.request.confirmation.mvp

import com.threed.printmatcher.fragment.di.FragmentScope
import com.threed.printmatcher.model.Submission
import com.threed.printmatcher.model.User
import com.threed.printmatcher.model.User.*
import javax.inject.Inject

@FragmentScope
class RequestConfirmationPresenter @Inject constructor(
    private val submission: Submission,
    private val user: Volunteer
) : RequestConfirmationContract.Presenter {

    private lateinit var mView: RequestConfirmationContract.View

    override fun onViewAvailable(view: RequestConfirmationContract.View) {
        mView = view
    }

    override fun onResume() {
        mView.loadImage(submission.request.imageResource)
        mView.fillTitle(submission.request.title)
        mView.fillSubtitle(submission.request.hospitalName)
        mView.fillCommittedQuantity(submission.committedQuantity)
        mView.fillInstitutionAddress(submission.request.location)
        mView.fillUserName(user.name)
        mView.fillUserContact(user.email)
        mView.fillUserLocation(user.address)
    }

    override fun onSubmitButtonClicked() {
        mView.navigateToSubmissionsListPage()
    }
}