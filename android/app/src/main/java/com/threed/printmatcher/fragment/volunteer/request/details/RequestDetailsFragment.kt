package com.threed.printmatcher.fragment.volunteer.request.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.threed.printmatcher.R
import com.threed.printmatcher.fragment.volunteer.request.details.mvp.RequestDetailsContract
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class RequestDetailsFragment : DaggerFragment() {

    @Inject
    lateinit var mPresenter: RequestDetailsContract.Presenter
    @Inject
    lateinit var mView: RequestDetailsContract.View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val pageLayout = inflater.inflate(R.layout.fragment_request_details, container, false)
        mView.bind(pageLayout)
        mPresenter.onViewAvailable(mView)
        return pageLayout
    }

    override fun onResume() {
        super.onResume()
        mPresenter.onResume()
    }
}

