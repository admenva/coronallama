package com.threed.supply.features.volunteer.submissions.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.threed.supply.R

class VolunteerSubmissionsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val root: View = itemView.findViewById(R.id.root)
    val image: ImageView = itemView.findViewById(R.id.image)
    val title: TextView = itemView.findViewById(R.id.title_tv)
    val status: TextView = itemView.findViewById(R.id.status_tv)
    val location: TextView = itemView.findViewById(R.id.location_tv)
}