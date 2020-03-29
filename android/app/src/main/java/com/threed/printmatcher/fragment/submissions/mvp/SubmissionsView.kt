package com.threed.printmatcher.fragment.submissions.mvp

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.threed.printmatcher.fragment.di.FragmentScope
import com.threed.printmatcher.fragment.submissions.adapter.SubmissionsAdapter
import com.threed.printmatcher.model.Submission
import kotlinx.android.synthetic.main.fragment_volunteer_home.view.*
import javax.inject.Inject

@FragmentScope
class SubmissionsView @Inject constructor(
    private val adapter: SubmissionsAdapter
) : SubmissionsContract.View {

    private lateinit var recyclerView: RecyclerView

    override fun bind(pageLayout: View) {
        recyclerView = pageLayout.recycler_view
        initRecyclerView()
    }

    override fun navigateToSubmissionDetails(item: Submission) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun initRecyclerView() {
        recyclerView.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(recyclerView.context)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }
}