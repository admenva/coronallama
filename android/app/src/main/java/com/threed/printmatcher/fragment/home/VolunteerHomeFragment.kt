package com.threed.printmatcher.fragment.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.threed.printmatcher.R
import com.threed.printmatcher.fragment.home.mvp.VolunteerHomeContract
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class VolunteerHomeFragment : DaggerFragment() {

    @Inject
    lateinit var mPresenter: VolunteerHomeContract.Presenter
    @Inject
    lateinit var mView: VolunteerHomeContract.View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val pageLayout = inflater.inflate(R.layout.fragment_volunteer_home, container, false)
        mView.bind(pageLayout)
        mPresenter.onViewAvailable(mView)
        return pageLayout
    }

    override fun onResume() {
        super.onResume()
        mPresenter.onResume()
    }
}