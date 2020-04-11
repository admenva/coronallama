package com.threed.supply.features.institution.requests.mvp

import com.threed.supply.features.di.FragmentScope
import com.threed.supply.libs.model.MockedRequests
import com.threed.supply.libs.model.Request
import javax.inject.Inject

@FragmentScope
class InstitutionRequestsModel @Inject constructor(mocekedRequests: MockedRequests) :
    InstitutionRequestsContract.Model {

    private val items: MutableList<Request> = mutableListOf()

    init {
        items.addAll(mocekedRequests.getRequestsList())
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemAt(position: Int): Request {
        return items[position]
    }

}