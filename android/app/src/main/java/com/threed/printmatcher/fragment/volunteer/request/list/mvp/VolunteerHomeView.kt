package com.threed.printmatcher.fragment.volunteer.request.list.mvp

import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.threed.printmatcher.fragment.di.FragmentScope
import com.threed.printmatcher.fragment.volunteer.request.list.VolunteerHomeFragmentDirections
import com.threed.printmatcher.fragment.volunteer.request.list.VolunteerHomeSearchBoxTextWatcher
import com.threed.printmatcher.fragment.volunteer.request.list.adapter.VolunteerHomeListAdapter
import com.threed.printmatcher.model.Request
import kotlinx.android.synthetic.main.fragment_volunteer_home.view.*
import kotlinx.android.synthetic.main.search_box_component.view.*
import javax.inject.Inject

@FragmentScope
class VolunteerHomeView @Inject constructor(
    private val textWatcher: VolunteerHomeSearchBoxTextWatcher,
    private val presenter: VolunteerHomeContract.Presenter,
    private val adapter: VolunteerHomeListAdapter
) :
    VolunteerHomeContract.View {

    private lateinit var recyclerView: RecyclerView
    private lateinit var currentLocationRow: View
    private lateinit var searchResultsHolder: View
    private lateinit var searchBox: EditText
    private lateinit var mockAutosuggestResult1Tv: TextView
    private lateinit var mockAutosuggestResult2Tv: TextView
    private lateinit var mockAutosuggestResult3Tv: TextView
    private lateinit var pageView: View

    override fun bind(pageView: View) {
        recyclerView = pageView.recycler_view
        currentLocationRow = pageView.current_location_row
        searchResultsHolder = pageView.search_results_holder
        searchBox = pageView.search_box
        mockAutosuggestResult1Tv = pageView.mock_result_1_tv
        mockAutosuggestResult2Tv = pageView.mock_result_2_tv
        mockAutosuggestResult3Tv = pageView.mock_result_3_tv
        initSearchBox()
        initMockedAutosuggestRows()
        initRecyclerView()
        this.pageView = pageView
    }

    override fun getSearchQuery(): String {
        return searchBox.text.toString()
    }

    override fun showMockedAutosuggestResults() {
        searchResultsHolder.visibility = View.VISIBLE
    }

    override fun hideMockedAutosuggestResults() {
        searchResultsHolder.visibility = View.GONE
    }

    override fun showCurrentLocationRow() {
        currentLocationRow.visibility = View.VISIBLE
    }

    override fun hideCurrentLocationRow() {
        currentLocationRow.visibility = View.GONE
    }

    override fun setSearchText(query: String) {
        searchBox.setText(query)
    }

    override fun navigateToRequestDetail(item: Request) {
        pageView.findNavController().navigate(VolunteerHomeFragmentDirections.homeToRequest(item))
    }

    override fun showSearchResultsList() {
        recyclerView.visibility = View.VISIBLE
    }

    override fun hideSearchResults() {
        recyclerView.visibility = View.GONE
    }

    private fun initSearchBox() {
        searchBox.setOnFocusChangeListener { _, hasFocus ->
            presenter.onSearchTextBoxFocusChanged(
                hasFocus
            )
        }
        searchBox.addTextChangedListener(textWatcher)
    }

    private fun initRecyclerView() {
        recyclerView.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(recyclerView.context)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }

    private fun initMockedAutosuggestRows() {
        currentLocationRow.setOnClickListener { presenter.onAutosuggestItemSelected("Your current location") }
        mockAutosuggestResult1Tv.setOnClickListener { presenter.onAutosuggestItemSelected("Result 1") }
        mockAutosuggestResult2Tv.setOnClickListener { presenter.onAutosuggestItemSelected("Result 2") }
        mockAutosuggestResult3Tv.setOnClickListener { presenter.onAutosuggestItemSelected("Result 3") }
    }
}