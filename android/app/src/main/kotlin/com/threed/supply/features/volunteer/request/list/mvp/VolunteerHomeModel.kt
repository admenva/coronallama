package com.threed.supply.features.volunteer.request.list.mvp

import com.threed.supply.features.di.FragmentScope
import com.threed.supply.libs.model.MockedRequests
import com.threed.supply.libs.model.Request
import javax.inject.Inject

@FragmentScope
class VolunteerHomeModel @Inject constructor(mocekedRequests: MockedRequests) :
    VolunteerHomeContract.Model {

    private val items: MutableList<Request> = mutableListOf()

    init {
        items.addAll(mocekedRequests.getRequestsList())
        items.addAll(mocekedRequests.getRequestsList())
        items.addAll(mocekedRequests.getRequestsList())
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun getItemAt(position: Int): Request {
        return items[position]
    }

}