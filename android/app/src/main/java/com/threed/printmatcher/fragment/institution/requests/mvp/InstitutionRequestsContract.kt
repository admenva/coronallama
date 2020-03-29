package com.threed.printmatcher.fragment.institution.requests.mvp

import com.threed.printmatcher.model.Request
import com.threed.printmatcher.model.Submission

interface InstitutionRequestsContract {

    interface Presenter {
        fun onViewAvailable(view: View)
        fun onRequestItemClicked(item: Request)
        fun onAddRequestButtonClicked()
    }

    interface View {
        fun bind(pageLayout: android.view.View)
        fun navigateToSubmissionDetails(item: Submission)
    }

    interface Model {
        fun getItemAt(position: Int): Request
        fun getItemCount(): Int
    }
}