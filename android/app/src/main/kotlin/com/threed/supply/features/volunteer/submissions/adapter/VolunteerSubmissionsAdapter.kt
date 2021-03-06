package com.threed.supply.features.volunteer.submissions.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.threed.supply.R
import com.threed.supply.features.volunteer.submissions.mvp.VolunteerSubmissionsContract
import javax.inject.Inject

class VolunteerSubmissionsAdapter @Inject constructor(
    private val presenter: VolunteerSubmissionsContract.Presenter,
    private val model: VolunteerSubmissionsContract.Model,
    private val picasso: Picasso
) : RecyclerView.Adapter<VolunteerSubmissionsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VolunteerSubmissionsViewHolder {
        return VolunteerSubmissionsViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.row_submissions,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: VolunteerSubmissionsViewHolder, position: Int) {
        val item = model.getItemAt(position)
        holder.location.text = item.request.location
        holder.title.text = "${item.committedQuantity} ${item.request.title}"
        holder.status.text=item.state.name
        picasso.load(item.request.imageResource).into(holder.image)
        holder.root.setOnClickListener { presenter.onSubmissionItemClicked(item) }
    }

    override fun getItemCount(): Int {
        return model.getItemCount()
    }
}