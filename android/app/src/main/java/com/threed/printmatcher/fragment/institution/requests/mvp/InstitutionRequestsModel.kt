package com.threed.printmatcher.fragment.institution.requests.mvp

import com.threed.printmatcher.fragment.di.FragmentScope
import com.threed.printmatcher.model.MockedRequests
import com.threed.printmatcher.model.Request
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