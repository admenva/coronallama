package com.threed.printmatcher.fragment.institution.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.threed.printmatcher.R
import com.threed.printmatcher.fragment.institution.create.mvp.NewRequestContract
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class NewRequestFragment : DaggerFragment() {

    @Inject
    lateinit var mPresenter: NewRequestContract.Presenter
    @Inject
    lateinit var mView: NewRequestContract.View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val pageLayout = inflater.inflate(R.layout.fragment_new_request, container, false)
        mView.bind(pageLayout)
        mPresenter.onViewAvailable(mView)
        return pageLayout
    }
}
