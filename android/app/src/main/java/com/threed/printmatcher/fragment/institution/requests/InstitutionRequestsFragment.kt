package com.threed.printmatcher.fragment.institution.requests

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.threed.printmatcher.R
import com.threed.printmatcher.fragment.institution.requests.mvp.InstitutionRequestsContract
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class InstitutionRequestsFragment : DaggerFragment() {

    @Inject
    lateinit var mPresenter: InstitutionRequestsContract.Presenter
    @Inject
    lateinit var mView: InstitutionRequestsContract.View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val pageLayout =
            inflater.inflate(R.layout.fragment_institution_requests, container, false)
        mView.bind(pageLayout)
        mPresenter.onViewAvailable(mView)
        return pageLayout
    }
}