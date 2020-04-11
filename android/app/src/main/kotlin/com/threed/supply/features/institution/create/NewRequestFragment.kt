package com.threed.supply.features.institution.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.threed.supply.R
import com.threed.supply.features.institution.create.mvp.NewRequestContract
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class NewRequestFragment : DaggerFragment() {

    @Inject
    lateinit var presenter: NewRequestContract.Presenter
    @Inject
    lateinit var view: NewRequestContract.View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val pageLayout = inflater.inflate(R.layout.fragment_new_request, container, false)
        view.bind(pageLayout)
        presenter.onViewAvailable(view)
        return pageLayout
    }
}
