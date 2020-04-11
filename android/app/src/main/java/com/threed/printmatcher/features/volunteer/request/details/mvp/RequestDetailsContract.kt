package com.threed.printmatcher.features.volunteer.request.details.mvp

import com.threed.printmatcher.model.Submission

interface RequestDetailsContract {

    interface Presenter {
        fun onViewAvailable(view: View)
        fun onResume()
        fun onOkButtonClicked(committedQuantity: Int)
    }

    interface View {
        fun bind(pageLayout: android.view.View)
        fun showHospitalImage(imageResource: String)
        fun showTitle(title: String)
        fun showDescription(description: String)
        fun showNeeds(needs: Int)
        fun showLocation(location: String)
        fun showMapImage()
        fun setupCommittedQuantitySection()
        fun navigateToRequestConfirmation(submission: Submission)
    }
}