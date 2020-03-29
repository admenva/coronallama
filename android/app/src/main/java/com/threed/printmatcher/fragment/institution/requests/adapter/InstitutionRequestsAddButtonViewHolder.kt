package com.threed.printmatcher.fragment.institution.requests.adapter

import android.view.View
import android.widget.Button
import com.threed.printmatcher.R

class InstitutionRequestsAddButtonViewHolder(itemView: View) :
    InstitutionRequestsViewHolderBase(itemView) {

    val button: Button = itemView.findViewById(R.id.add_request)
}