package com.threed.supply.features.volunteer.request.list.mvp

import com.threed.supply.features.di.FragmentScope
import com.threed.supply.libs.model.Request
import com.threed.supply.libs.util.ToastManager
import javax.inject.Inject

@FragmentScope
class VolunteerHomePresenter @Inject constructor(private val toastManager: ToastManager) :
    VolunteerHomeContract.Presenter {

    private lateinit var view: VolunteerHomeContract.View

    override fun onViewAvailable(view: VolunteerHomeContract.View) {
        this.view = view
    }

    override fun onResume() {
        setupSearchBox()
        view.hideSearchResults()
    }

    override fun onSearchTextBoxFocusChanged(hasFocus: Boolean) {
        if (hasFocus) {
            setupSearchBox()
        } else {
            view.hideMockedAutosuggestResults()
            view.hideCurrentLocationRow()
        }
    }

    override fun onSearchTextChanged(text: String) {
        view.showCurrentLocationRow()
        view.hideSearchResults()
        if (text.isNotEmpty()) {
            view.showMockedAutosuggestResults()
        } else {
            view.hideMockedAutosuggestResults()
        }
    }

    override fun onAutosuggestItemSelected(query: String) {
        view.setSearchText(query)
        view.hideMockedAutosuggestResults()
        view.hideCurrentLocationRow()
        view.showSearchResultsList()
    }

    override fun onRequestItemClicked(item: Request) {
        view.navigateToRequestDetail(item)
    }

    private fun setupSearchBox() {
        view.showCurrentLocationRow()
        if (view.getSearchQuery().isNotEmpty()) {
            view.showMockedAutosuggestResults()
        } else {
            view.hideMockedAutosuggestResults()
        }
    }
}