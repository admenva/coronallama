package com.threed.printmatcher.fragment.request.confirmation.mvp

import com.threed.printmatcher.model.Submission

interface RequestConfirmationContract {

    interface Presenter {
        fun onViewAvailable(view: View)
        fun onResume()
        fun onSubmitButtonClicked()
    }

    interface View {
        fun bind(pageLayout: android.view.View)
        fun loadImage(imageResource: String)
        fun fillTitle(title: String)
        fun fillInstitutionAddress(location: String)
        fun fillUserName(name: String)
        fun fillUserContact(contact: String)
        fun fillUserLocation(address: String)
        fun fillCommittedQuantity(committedQuantity: Int)
        fun navigateToSubmissionsListPage(submission: Submission)
    }
}