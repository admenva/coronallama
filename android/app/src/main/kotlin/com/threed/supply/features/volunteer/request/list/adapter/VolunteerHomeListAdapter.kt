package com.threed.supply.features.volunteer.request.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.threed.supply.R
import com.threed.supply.features.di.FragmentScope
import com.threed.supply.features.volunteer.request.list.mvp.VolunteerHomeContract
import javax.inject.Inject

@FragmentScope
class VolunteerHomeListAdapter @Inject constructor(
    private val presenter: VolunteerHomeContract.Presenter,
    private val model: VolunteerHomeContract.Model,
    private val picasso: Picasso
) : RecyclerView.Adapter<VolunteerHomeListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VolunteerHomeListViewHolder {
        return VolunteerHomeListViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.row_volunteer_home,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: VolunteerHomeListViewHolder, position: Int) {
        val item = model.getItemAt(position)
        holder.location.text = item.location
        holder.title.text = "${item.requested} ${item.title}"
        holder.hospital.text = item.hospitalName
        picasso.load(item.imageResource).into(holder.image)
        holder.root.setOnClickListener { presenter.onRequestItemClicked(item) }
    }

    override fun getItemCount(): Int {
        return model.getItemCount()
    }
}