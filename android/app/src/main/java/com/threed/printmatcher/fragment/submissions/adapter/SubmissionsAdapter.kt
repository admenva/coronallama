package com.threed.printmatcher.fragment.submissions.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.threed.printmatcher.R
import com.threed.printmatcher.fragment.submissions.mvp.SubmissionsContract
import javax.inject.Inject

class SubmissionsAdapter @Inject constructor(
    private val presenter: SubmissionsContract.Presenter,
    private val model: SubmissionsContract.Model,
    private val picasso: Picasso
) : RecyclerView.Adapter<SubmissionsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubmissionsViewHolder {
        return SubmissionsViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.submissions_list_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SubmissionsViewHolder, position: Int) {
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