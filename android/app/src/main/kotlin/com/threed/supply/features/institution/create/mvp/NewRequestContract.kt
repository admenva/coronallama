package com.threed.supply.features.institution.create.mvp

import com.threed.supply.libs.model.Request

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