package com.threed.printmatcher.features.institution.requests

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.threed.printmatcher.R
import com.threed.printmatcher.features.institution.requests.mvp.InstitutionRequestsContract
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class InstitutionRequestsFragment : DaggerFragment() {

    @Inject
    lateinit var presenter: InstitutionRequestsContract.Presenter
    @Inject
    lateinit var view: InstitutionRequestsContract.View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val pageLayout =
            inflater.inflate(R.layout.fragment_institution_requests, container, false)
        view.bind(pageLayout)
        presenter.onViewAvailable(view)
        return pageLayout
    }
}