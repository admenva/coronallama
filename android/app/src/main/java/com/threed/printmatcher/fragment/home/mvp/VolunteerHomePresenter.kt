package com.threed.printmatcher.fragment.home.mvp

import com.threed.printmatcher.fragment.di.FragmentScope
import com.threed.printmatcher.model.Request
import com.threed.printmatcher.util.ToastManager
import javax.inject.Inject

@FragmentScope
class VolunteerHomePresenter @Inject constructor(private val toastManager: ToastManager) :
    VolunteerHomeContract.Presenter {

    private lateinit var mView: VolunteerHomeContract.View

    override fun onViewAvailable(view: VolunteerHomeContract.View) {
        mView = view
    }

    override fun onResume() {
        setupSearchBox()
        mView.hideSearchResults()
    }

    override fun onSearchTextBoxFocusChanged(hasFocus: Boolean) {
        if (hasFocus) {
            setupSearchBox()
        } else {
            mView.hideMockedAutosuggestResults()
            mView.hideCurrentLocationRow()
        }
    }

    override fun onSearchTextChanged(text: String) {
        mView.showCurrentLocationRow()
        mView.hideSearchResults()
        if (text.isNotEmpty()) {
            mView.showMockedAutosuggestResults()
        } else {
            mView.hideMockedAutosuggestResults()
        }
    }

    override fun onAutosuggestItemSelected(query: String) {
        mView.setSearchText(query)
        mView.hideMockedAutosuggestResults()
        mView.hideCurrentLocationRow()
        mView.showSearchResultsList()
    }

    override fun onRequestItemClicked(item: Request) {
        //TODO Open RequestDetailsFragment with the Request added to the arguments as Serializable (with tag "request")
        toastManager.show("${item.title} clicked")
    }

    private fun setupSearchBox() {
        mView.showCurrentLocationRow()
        if (mView.getSearchQuery().isNotEmpty()) {
            mView.showMockedAutosuggestResults()
        } else {
            mView.hideMockedAutosuggestResults()
        }
    }
}