package com.threed.supply.features.institution.requests.adapter

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.threed.supply.R
import com.threed.supply.features.institution.requests.mvp.InstitutionRequestsContract
import javax.inject.Inject

class InstitutionRequestsAdapter @Inject constructor(
    private val presenter: InstitutionRequestsContract.Presenter,
    private val model: InstitutionRequestsContract.Model,
    private val picasso: Picasso,
    private val resources: Resources
) : RecyclerView.Adapter<InstitutionRequestsViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): InstitutionRequestsViewHolder =
        InstitutionRequestsViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.row_institution_home,
                parent,
                false
            )
        )

    override fun onBindViewHolder(
        holder: InstitutionRequestsViewHolder,
        position: Int
    ) = bindRow(holder, position)

    override fun getItemCount(): Int = model.getItemCount()

    private fun bindRow(holder: InstitutionRequestsViewHolder, position: Int) {
        val item = model.getItemAt(position)
        holder.title.text = item.title
        holder.requested.text =
            String.format(resources.getString(R.string.requested_formatter), item.requested)
        holder.pending.text = String.format(
            resources.getString(R.string.pending_completed_formatter),
            (item.requested - item.stillNeeded)
        )
        holder.stillNeeds.text =
            String.format(resources.getString(R.string.needs_formatter), item.stillNeeded)

        picasso.load(item.imageResource).into(holder.image)
        holder.root.setOnClickListener { presenter.onRequestItemClicked(item) }
    }
}