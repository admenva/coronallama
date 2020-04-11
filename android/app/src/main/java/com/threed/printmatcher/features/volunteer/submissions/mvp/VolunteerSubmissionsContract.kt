package com.threed.printmatcher.features.volunteer.submissions.mvp

import com.threed.printmatcher.model.Submission

interface VolunteerSubmissionsContract {

    interface Presenter {
        fun onViewAvailable(view: View)
        fun onSubmissionItemClicked(item: Submission)
    }

    interface View {
        fun bind(pageLayout: android.view.View)
        fun navigateToSubmissionDetails(item: Submission)
    }

    interface Model {
        fun getItemAt(position: Int): Submission
        fun getItemCount(): Int
    }
}