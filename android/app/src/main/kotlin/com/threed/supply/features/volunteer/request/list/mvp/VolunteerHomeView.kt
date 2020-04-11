package com.threed.supply.features.volunteer.request.list.mvp

import android.view.View
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import com.threed.supply.features.di.FragmentScope
import com.threed.supply.features.volunteer.request.list.VolunteerHomeFragmentDirections
import com.threed.supply.features.volunteer.request.list.VolunteerHomeSearchBoxTextWatcher
import com.threed.supply.features.volunteer.request.list.adapter.VolunteerHomeListAdapter
import com.threed.supply.libs.model.Request
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
    private lateinit var searchBox: TextInputEditText
    private lateinit var mockResult1: TextView
    private lateinit var mockResult2: TextView
    private lateinit var mockResult3: TextView
    private lateinit var pageView: View

    override fun bind(pageView: View) {
        recyclerView = pageView.recycler_view
        currentLocationRow = pageView.current_location_row
        searchResultsHolder = pageView.search_results_holder
        searchBox = pageView.search_input
        mockResult1 = pageView.mock_result_1_tv
        mockResult2 = pageView.mock_result_2_tv
        mockResult3 = pageView.mock_result_3_tv
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
        currentLocationRow.setOnClickListener { presenter.onAutosuggestItemSelected("Staple Inn, London") }
        mockResult1.setOnClickListener { presenter.onAutosuggestItemSelected(mockResult1.text.toString()) }
        mockResult2.setOnClickListener { presenter.onAutosuggestItemSelected(mockResult2.text.toString()) }
        mockResult3.setOnClickListener { presenter.onAutosuggestItemSelected(mockResult3.text.toString()) }
    }
}