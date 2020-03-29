package com.threed.printmatcher.fragment.submissions.institution

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.threed.printmatcher.R
import com.threed.printmatcher.fragment.submissions.institution.mvp.InstitutionSubmissionsContract
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class InstitutionSubmissionsFragment : DaggerFragment() {

    @Inject
    lateinit var mPresenter: InstitutionSubmissionsContract.Presenter
    @Inject
    lateinit var mView: InstitutionSubmissionsContract.View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val pageLayout =
            inflater.inflate(R.layout.fragment_institution_submissions, container, false)
        mView.bind(pageLayout)
        mPresenter.onViewAvailable(mView)
        return pageLayout
    }
}