package com.threed.printmatcher.fragment.home.mvp

import com.threed.printmatcher.model.Request

interface VolunteerHomeContract {

    interface Presenter {
        fun onViewAvailable(view: View)
        fun onResume()
        fun onSearchTextBoxFocusChanged(hasFocus: Boolean)
        fun onSearchTextChanged(text: String)
        fun onAutosuggestItemSelected(query: String)
        fun onRequestItemClicked(item: Request)
    }

    interface View {
        fun bind(pageView: android.view.View)
        fun getSearchQuery(): String
        fun showMockedAutosuggestResults()
        fun hideMockedAutosuggestResults()
        fun showCurrentLocationRow()
        fun showSearchResultsList()
        fun hideSearchResults()
        fun hideCurrentLocationRow()
        fun setSearchText(query: String)
    }

    interface Model {
        fun getItemCount(): Int
        fun getItemAt(position: Int): Request
    }
}