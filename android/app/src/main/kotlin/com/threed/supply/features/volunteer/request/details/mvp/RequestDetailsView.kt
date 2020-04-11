package com.threed.supply.features.volunteer.request.details.mvp

import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import com.squareup.picasso.Picasso
import com.threed.supply.features.di.FragmentScope
import com.threed.supply.features.volunteer.request.details.RequestDetailsFragmentDirections
import com.threed.supply.libs.model.Submission
import kotlinx.android.synthetic.main.fragment_request_details.view.*
import javax.inject.Inject

private const val STATIC_MAP_IMAGE_RESOURCE = "https://i.stack.imgur.com/dApg7.png"

@FragmentScope
class RequestDetailsView @Inject constructor(
    private val picasso: Picasso,
    private val presenter: RequestDetailsContract.Presenter
) : RequestDetailsContract.View {

    private lateinit var pageLayout: View
    private lateinit var image: ImageView
    private lateinit var titleTv: TextView
    private lateinit var descriptionTv: TextView
    private lateinit var quantityTv: TextView
    private lateinit var locationTv: TextView
    private lateinit var mapImage: ImageView
    private lateinit var minus: ImageView
    private lateinit var committedQuantity: EditText
    private lateinit var okBtn: Button
    private lateinit var plus: ImageView

    override fun bind(pageLayout: View) {
        image = pageLayout.image
        titleTv = pageLayout.title
        descriptionTv = pageLayout.description
        quantityTv = pageLayout.quantity
        locationTv = pageLayout.location
        mapImage = pageLayout.map_image
        minus = pageLayout.minus
        committedQuantity = pageLayout.commited_quantity
        plus = pageLayout.plus
        okBtn = pageLayout.ok
        this.pageLayout = pageLayout
        setupOkBtn()
    }

    override fun showHospitalImage(imageResource: String) {
        picasso.load(imageResource).into(image)
    }

    override fun showTitle(title: String) {
        titleTv.text = title
    }

    override fun showDescription(description: String) {
        descriptionTv.text = description
    }

    override fun showNeeds(needs: Int) {
        quantityTv.text = needs.toString()
    }

    override fun showLocation(location: String) {
        locationTv.text = location
    }

    override fun showMapImage() {
        picasso.load(STATIC_MAP_IMAGE_RESOURCE).into(mapImage)
    }

    override fun setupCommittedQuantitySection() {
        setupMinus()
        setupPlus()
        setupTextBox()
    }

    override fun navigateToRequestConfirmation(submission: Submission) {
        pageLayout.findNavController().navigate(
            RequestDetailsFragmentDirections.requestDetailsToConfirmation(submission)
        )
    }

    private fun setupTextBox() {
        committedQuantity.setText("0")
    }

    private fun setupPlus() {
        plus.setOnClickListener {
            committedQuantity.setText((committedQuantity.text.toString().toInt() + 1).toString())
        }
    }

    private fun setupMinus() {
        minus.setOnClickListener {
            val quantity = committedQuantity.text.toString().toInt()
            if (quantity > 1) {
                committedQuantity.setText((committedQuantity.text.toString().toInt() - 1).toString())
            }
        }
    }

    private fun setupOkBtn() {
        okBtn.setOnClickListener { presenter.onOkButtonClicked(committedQuantity.text.toString().toInt()) }
    }
}