package com.threed.printmatcher.fragment.submissions.institution.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.threed.printmatcher.R
import com.threed.printmatcher.fragment.submissions.institution.mvp.InstitutionSubmissionsContract
import javax.inject.Inject

class InstitutionSubmissionsAdapter @Inject constructor(
    private val presenter: InstitutionSubmissionsContract.Presenter,
    private val model: InstitutionSubmissionsContract.Model,
    private val picasso: Picasso
) : RecyclerView.Adapter<InstitutionSubmissionsViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): InstitutionSubmissionsViewHolder {
        return InstitutionSubmissionsViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.institution_home_list_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: InstitutionSubmissionsViewHolder, position: Int) {
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