package com.threed.printmatcher.fragment.institution.requests.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.threed.printmatcher.R

class InstitutionRequestsViewHolder(itemView: View) : InstitutionRequestsViewHolderBase(itemView) {

    val root: View = itemView.findViewById(R.id.root)
    val image: ImageView = itemView.findViewById(R.id.image)
    val title: TextView = itemView.findViewById(R.id.title_tv)
    val requested: TextView = itemView.findViewById(R.id.requested_tv)
    val pending: TextView = itemView.findViewById(R.id.pending_tv)
    val stillNeeds: TextView = itemView.findViewById(R.id.still_needs_tv)
}