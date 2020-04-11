package com.threed.supply.app.activity.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.threed.supply.libs.model.User

class AppViewModel internal constructor() : ViewModel() {

    private val user = MutableLiveData<User>()

    fun setUser(user: User) {
        this.user.value = user
    }

    fun getUser(): LiveData<User> {
        return user
    }

}