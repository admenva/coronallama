package com.threed.printmatcher.fragment.home

import android.text.Editable
import android.text.TextWatcher
import com.threed.printmatcher.fragment.di.FragmentScope
import com.threed.printmatcher.fragment.home.mvp.VolunteerHomeContract
import javax.inject.Inject

@FragmentScope
class VolunteerHomeSearchBoxTextWatcher @Inject constructor(private val presenter: VolunteerHomeContract.Presenter) : TextWatcher {

    override fun afterTextChanged(searchText: Editable?) {
        if (searchText != null) {
            presenter.onSearchTextChanged(searchText.toString())
        }
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        //NO-OP
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        //NO-OP
    }


}