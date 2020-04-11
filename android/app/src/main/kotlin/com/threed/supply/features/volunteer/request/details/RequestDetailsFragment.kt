package com.threed.supply.features.volunteer.request.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.threed.supply.R
import com.threed.supply.features.volunteer.request.details.mvp.RequestDetailsContract
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class RequestDetailsFragment : DaggerFragment() {

    @Inject
    lateinit var presenter: RequestDetailsContract.Presenter
    @Inject
    lateinit var view: RequestDetailsContract.View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val pageLayout = inflater.inflate(R.layout.fragment_request_details, container, false)
        view.bind(pageLayout)
        presenter.onViewAvailable(view)
        return pageLayout
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }
}

