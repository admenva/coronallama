package com.threed.printmatcher.fragment.request.confirmation.mvp

import com.threed.printmatcher.fragment.di.FragmentScope
import com.threed.printmatcher.model.Submission
import com.threed.printmatcher.model.User
import javax.inject.Inject

@FragmentScope
class RequestConfirmationPresenter @Inject constructor(
    private val submission: Submission,
    private val user: User.Volunteer
) : RequestConfirmationContract.Presenter {

    private lateinit var mView: RequestConfirmationContract.View

    override fun onViewAvailable(view: RequestConfirmationContract.View) {
        mView = view
    }

    override fun onResume() {
        mView.loadImage(submission.request.imageResource)
        mView.fillTitle(submission.request.title)
        mView.fillCommittedQuantity(submission.committedQuantity)
        mView.fillInstitutionAddress(submission.request.location)
        mView.fillUserName("${user.firstName} ${user.lastName}")
        mView.fillUserContact(user.contact)
        mView.fillUserLocation(user.address)
    }

    override fun onSubmitButtonClicked() {
        mView.navigateToSubmissionsListPage(submission)
    }
}