package com.threed.printmatcher.fragment.institution.create.mvp

import com.threed.printmatcher.model.Request

interface NewRequestContract {

    interface Presenter {
        fun onViewAvailable(view: View)
        fun onCreateButtonClicked(item: Request)
    }

    interface View {
        fun bind(pageLayout: android.view.View)
        fun navigateToRequestsPage(item: Request)
    }
}