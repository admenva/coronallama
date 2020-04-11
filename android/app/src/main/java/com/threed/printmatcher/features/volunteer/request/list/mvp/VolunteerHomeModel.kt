package com.threed.printmatcher.features.volunteer.request.list.mvp

import com.threed.printmatcher.features.di.FragmentScope
import com.threed.printmatcher.model.MockedRequests
import com.threed.printmatcher.model.Request
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