package com.threed.printmatcher.fragment.request.confirmation.mvp

import com.threed.printmatcher.fragment.di.FragmentScope
import com.threed.printmatcher.fragment.request.confirmation.di.CommittedQuantity
import com.threed.printmatcher.model.Request
import com.threed.printmatcher.model.User
import javax.inject.Inject

@FragmentScope
class RequestConfirmationPresenter @Inject constructor(
    private val request: Request,
    @CommittedQuantity private val committedQuantity: Int,
    private val user: User.Volunteer
) : RequestConfirmationContract.Presenter {

    private lateinit var mView: RequestConfirmationContract.View

    override fun onViewAvailable(view: RequestConfirmationContract.View) {
        mView = view
    }

    override fun onResume() {
        mView.loadImage(request.imageResource)
        mView.fillTitle(request.title)
        mView.fillCommittedQuantity(committedQuantity)
        mView.fillInstitutionAddress(request.location)
        mView.fillUserName("${user.firstName} ${user.lastName}")
        mView.fillUserContact(user.contact)
        mView.fillUserLocation(user.address)
    }

    override fun onSubmitButtonClicked() {
        //TODO go to my submissions page
    }
}