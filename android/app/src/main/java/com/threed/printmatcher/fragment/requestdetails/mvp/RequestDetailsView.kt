package com.threed.printmatcher.fragment.requestdetails.mvp

import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.threed.printmatcher.fragment.di.FragmentScope
import com.threed.printmatcher.util.ToastManager
import kotlinx.android.synthetic.main.fragment_request_details.view.*
import javax.inject.Inject

private const val STATIC_MAP_IMAGE_RESOURCE = "https://i.stack.imgur.com/dApg7.png"

@FragmentScope
class RequestDetailsView @Inject constructor(
    private val picasso: Picasso,
    private val toastManager: ToastManager
) :
    RequestDetailsContract.View {

    private lateinit var image: ImageView
    private lateinit var titleTv: TextView
    private lateinit var descriptionTv: TextView
    private lateinit var quantityTv: TextView
    private lateinit var locationTv: TextView
    private lateinit var mapImage: ImageView
    private lateinit var minus: ImageView
    private lateinit var commitedQuantity: EditText
    private lateinit var plus: ImageView
    private lateinit var okBtn: Button

    override fun bind(pageLayout: View) {
        image = pageLayout.image
        titleTv = pageLayout.title
        descriptionTv = pageLayout.description
        quantityTv = pageLayout.quantity
        locationTv = pageLayout.location
        mapImage = pageLayout.map_image
        minus = pageLayout.minus
        commitedQuantity = pageLayout.commited_quantity
        plus = pageLayout.plus
        okBtn = pageLayout.ok
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

    override fun setupCommitedQuantitySection(maxValue: Int) {
        setupMinus()
        setupPlus(maxValue)
        setupTextBox()
    }

    private fun setupTextBox() {
        commitedQuantity.setText("0")
    }

    private fun setupPlus(maxValue: Int) {
        plus.setOnClickListener {
            commitedQuantity.setText((commitedQuantity.text.toString().toInt() + 1).toString())
        }
    }

    private fun setupMinus() {
        minus.setOnClickListener {
            val quantity = commitedQuantity.text.toString().toInt()
            if (quantity > 1) {
                commitedQuantity.setText((commitedQuantity.text.toString().toInt() - 1).toString())
            }
        }
    }

    private fun setupOkBtn() {
        //TODO set up validaton for the quantity
        okBtn.setOnClickListener { toastManager.show("Ok clicked!") }
    }
}