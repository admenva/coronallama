package com.threed.supply.features.institution.requests.mvp

import android.view.View
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.threed.supply.features.di.FragmentScope
import com.threed.supply.features.institution.requests.InstitutionRequestsFragmentDirections
import com.threed.supply.features.institution.requests.adapter.InstitutionRequestsAdapter
import com.threed.supply.libs.model.Submission
import kotlinx.android.synthetic.main.fragment_institution_requests.view.*
import kotlinx.android.synthetic.main.fragment_volunteer_home.view.recycler_view
import javax.inject.Inject

@FragmentScope
class InstitutionRequestsView @Inject constructor(
    private val adapter: InstitutionRequestsAdapter,
    private val presenter: InstitutionRequestsContract.Presenter
) :
    InstitutionRequestsContract.View {

    private lateinit var recyclerView: RecyclerView
    private lateinit var addBtn: FloatingActionButton
    private lateinit var pageView: View

    override fun bind(pageLayout: View) {
        pageView = pageLayout
        addBtn = pageLayout.add_request
        recyclerView = pageLayout.recycler_view

        setupAddBtn()
        initRecyclerView()
    }

    override fun navigateToSubmissionDetails(item: Submission) {
        //TODO navigate to the details page. But which one?
    }

    override fun navigateToCreateRequestPage() {
        pageView.findNavController()
            .navigate(InstitutionRequestsFragmentDirections.requestsToCreateRequest())
    }

    private fun initRecyclerView() {
        recyclerView.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(recyclerView.context)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }

    private fun setupAddBtn() = addBtn.setOnClickListener { presenter.onAddRequestButtonClicked() }
}
