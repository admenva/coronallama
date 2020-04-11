package com.threed.printmatcher.features.volunteer.request.confirmation.mvp

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import com.squareup.picasso.Picasso
import com.threed.printmatcher.features.di.FragmentScope
import com.threed.printmatcher.features.volunteer.request.confirmation.RequestConfirmationFragmentDirections
import kotlinx.android.synthetic.main.fragment_request_confirmation.view.*
import javax.inject.Inject

@FragmentScope
class RequestConfirmationView @Inject constructor(
    private val picasso: Picasso,
    private val presenter: RequestConfirmationContract.Presenter
) : RequestConfirmationContract.View {

    private lateinit var pageLayout: View
    private lateinit var image: ImageView
    private lateinit var titleTv: TextView
    private lateinit var subtitleTv: TextView
    private lateinit var quantity: TextView
    private lateinit var locationTv: TextView
    private lateinit var nameTv: TextView
    private lateinit var contactTv: TextView
    private lateinit var userLocationTv: TextView
    private lateinit var submitBtn: Button

    override fun bind(pageLayout: View) {
        this.pageLayout = pageLayout
        image = pageLayout.image
        titleTv = pageLayout.title
        subtitleTv = pageLayout.subtitle
        quantity = pageLayout.quantity
        locationTv = pageLayout.location
        nameTv = pageLayout.name
        contactTv = pageLayout.contact
        userLocationTv = pageLayout.user_location
        submitBtn = pageLayout.submit

        setupSubmitBtn()
    }

    override fun loadImage(imageResource: String) {
        picasso.load(imageResource).into(image)
    }

    override fun fillTitle(title: String) {
        titleTv.text = title
    }

    override fun fillSubtitle(hospitalName: String) {
        subtitleTv.text = hospitalName
    }

    override fun fillInstitutionAddress(location: String) {
        locationTv.text = location
    }

    override fun fillUserName(name: String) {
        nameTv.text = name
    }

    override fun fillUserContact(contact: String) {
        contactTv.text = contact
    }

    override fun fillUserLocation(address: String) {
        userLocationTv.text = address
    }

    override fun fillCommittedQuantity(committedQuantity: Int) {
        quantity.text = committedQuantity.toString()
    }

    override fun navigateToSubmissionsListPage() {
        pageLayout.findNavController().navigate(
            RequestConfirmationFragmentDirections.confirmationToSubmissions()
        )
    }

    private fun setupSubmitBtn() {
        submitBtn.setOnClickListener { presenter.onSubmitButtonClicked() }
    }
}