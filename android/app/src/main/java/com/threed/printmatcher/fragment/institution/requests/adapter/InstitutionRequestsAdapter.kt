package com.threed.printmatcher.fragment.institution.requests.adapter

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.threed.printmatcher.R
import com.threed.printmatcher.fragment.institution.requests.mvp.InstitutionRequestsContract
import javax.inject.Inject

private const val VIEW_TYPE_NORMAL = 0
private const val VIEW_TYPE_BUTTON = 1

class InstitutionRequestsAdapter @Inject constructor(
    private val presenter: InstitutionRequestsContract.Presenter,
    private val model: InstitutionRequestsContract.Model,
    private val picasso: Picasso,
    private val resources: Resources
) : RecyclerView.Adapter<InstitutionRequestsViewHolderBase>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): InstitutionRequestsViewHolderBase {

        return if (viewType == VIEW_TYPE_NORMAL) {
            InstitutionRequestsViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.row_institution_home,
                    parent,
                    false
                )
            )
        } else {
            InstitutionRequestsAddButtonViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.row_add_request_button,
                    parent,
                    false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: InstitutionRequestsViewHolderBase, position: Int) {
        if (getItemViewType(position) == VIEW_TYPE_NORMAL) {
            bindRow(holder as InstitutionRequestsViewHolder, position)
        } else {
            bindAddRequestButton(holder as InstitutionRequestsAddButtonViewHolder)
        }

    }

    override fun getItemCount(): Int {
        return model.getItemCount() + 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == itemCount - 1) {
            VIEW_TYPE_BUTTON
        } else {
            VIEW_TYPE_NORMAL
        }
    }

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
    
    private fun bindAddRequestButton(holder: InstitutionRequestsAddButtonViewHolder) {
        holder.button.setOnClickListener { presenter.onAddRequestButtonClicked() }
    }

}