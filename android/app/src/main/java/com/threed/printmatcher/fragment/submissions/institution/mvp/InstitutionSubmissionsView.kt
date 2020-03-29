package com.threed.printmatcher.fragment.submissions.institution.mvp

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.threed.printmatcher.fragment.di.FragmentScope
import com.threed.printmatcher.fragment.submissions.institution.adapter.InstitutionSubmissionsAdapter
import com.threed.printmatcher.model.Submission
import kotlinx.android.synthetic.main.fragment_volunteer_home.view.*
import javax.inject.Inject

@FragmentScope
class InstitutionSubmissionsView @Inject constructor(private val adapter: InstitutionSubmissionsAdapter) :
    InstitutionSubmissionsContract.View {

    private lateinit var recyclerView: RecyclerView

    override fun bind(pageLayout: View) {
        recyclerView = pageLayout.recycler_view
        initRecyclerView()
    }

    override fun navigateToSubmissionDetails(item: Submission) {
        //TODO navigate to the details page. But which one?
    }

    private fun initRecyclerView() {
        recyclerView.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(recyclerView.context)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }
}