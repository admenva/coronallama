package com.threed.printmatcher.fragment.institution.requests.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.threed.printmatcher.R
import com.threed.printmatcher.fragment.institution.requests.mvp.InstitutionRequestsContract
import javax.inject.Inject

class InstitutionRequestsAdapter @Inject constructor(
    private val presenter: InstitutionRequestsContract.Presenter,
    private val model: InstitutionRequestsContract.Model,
    private val picasso: Picasso
) : RecyclerView.Adapter<InstitutionRequestsViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): InstitutionRequestsViewHolder {
        return InstitutionRequestsViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.institution_home_list_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: InstitutionRequestsViewHolder, position: Int) {
        val item = model.getItemAt(position)
        holder.location.text = item.request.location
        holder.title.text = "${item.committedQuantity} ${item.request.title}"
        holder.status.text = item.state.name
        picasso.load(item.request.imageResource).into(holder.image)
        holder.root.setOnClickListener { presenter.onSubmissionItemClicked(item) }
    }

    override fun getItemCount(): Int {
        return model.getItemCount()
    }
}