package com.threed.printmatcher.fragment.submissions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.threed.printmatcher.R
import com.threed.printmatcher.fragment.submissions.mvp.SubmissionsContract
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class SubmissionsFragment : DaggerFragment() {

    @Inject
    lateinit var mPresenter: SubmissionsContract.Presenter
    @Inject
    lateinit var mView: SubmissionsContract.View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val pageLayout = inflater.inflate(R.layout.fragment_volunteer_submissions, container, false)
        mView.bind(pageLayout)
        mPresenter.onViewAvailable(mView)
        return pageLayout
    }
}