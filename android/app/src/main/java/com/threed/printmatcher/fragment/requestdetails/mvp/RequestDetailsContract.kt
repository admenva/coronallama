package com.threed.printmatcher.fragment.requestdetails.mvp

import android.view.View

interface RequestDetailsContract {

    interface Presenter {
        fun onViewAvailable(mView: View)
        fun onResume()
    }

    interface View {
        fun bind(pageLayout: android.view.View)
        fun showHospitalImage(imageResource: String)
        fun showTitle(title: String)
        fun showDescription(description: String)
        fun showNeeds(needs: Int)
        fun showLocation(location: String)
        fun showMapImage()
        fun setupCommitedQuantitySection(needs: Int)
    }
}