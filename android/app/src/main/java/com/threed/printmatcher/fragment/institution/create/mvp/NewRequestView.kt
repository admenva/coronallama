package com.threed.printmatcher.fragment.institution.create.mvp

import android.view.View
import android.widget.Button
import androidx.navigation.findNavController
import com.google.android.material.textfield.TextInputEditText
import com.threed.printmatcher.fragment.di.FragmentScope
import com.threed.printmatcher.fragment.institution.create.NewRequestFragmentDirections
import com.threed.printmatcher.model.Request
import kotlinx.android.synthetic.main.fragment_new_request.view.*
import javax.inject.Inject

@FragmentScope
class NewRequestView @Inject constructor(
    private val presenter: NewRequestContract.Presenter
) : NewRequestContract.View {

    private lateinit var pageLayout: View
    private lateinit var titleTv: TextInputEditText
    private lateinit var descriptionTv: TextInputEditText
    private lateinit var quantity: TextInputEditText
    private lateinit var locationTv: TextInputEditText
    private lateinit var createBtn: Button

    override fun bind(pageLayout: View) {
        this.pageLayout = pageLayout
        createBtn = pageLayout.create_btn
        titleTv = pageLayout.title_input
        descriptionTv = pageLayout.description_input
        quantity = pageLayout.quantity_input
        locationTv = pageLayout.address_input

        setupSubmitBtn()
    }

    override fun navigateToRequestsPage(item: Request) {
        pageLayout.findNavController().navigate(NewRequestFragmentDirections.newRequestToRequests(item))
    }

    private fun setupSubmitBtn() {
        createBtn.setOnClickListener {
            presenter.onCreateButtonClicked(
                Request(
                    titleTv.text.toString(),
                    "St Thomas Hospital",
                    descriptionTv.text.toString(),
                    locationTv.text.toString(),
                    "https://cdn.prusa3d.com/wp-content/uploads/2020/03/shield-1.jpg#_ga=2.232288287.1611879560.1585533938-907588876.1585361799",
                    300,
                    300
                )
            )
        }
    }
}