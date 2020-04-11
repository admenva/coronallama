package com.threed.supply.features.institution.requests.mvp

import com.threed.supply.libs.model.Request
import com.threed.supply.libs.model.Submission

interface InstitutionRequestsContract {

    interface Presenter {
        fun onViewAvailable(view: View)
        fun onRequestItemClicked(item: Request)
        fun onAddRequestButtonClicked()
    }

    interface View {
        fun bind(pageLayout: android.view.View)
        fun navigateToSubmissionDetails(item: Submission)
        fun navigateToCreateRequestPage()
    }

    interface Model {
        fun getItemAt(position: Int): Request
        fun getItemCount(): Int
    }
}