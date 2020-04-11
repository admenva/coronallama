package com.threed.printmatcher.features.volunteer.submissions.mvp

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.threed.printmatcher.features.di.FragmentScope
import com.threed.printmatcher.features.volunteer.submissions.adapter.VolunteerSubmissionsAdapter
import com.threed.printmatcher.model.Submission
import kotlinx.android.synthetic.main.fragment_volunteer_home.view.*
import javax.inject.Inject

@FragmentScope
class VolunteerSubmissionsView @Inject constructor(
    private val adapter: VolunteerSubmissionsAdapter
) : VolunteerSubmissionsContract.View {

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