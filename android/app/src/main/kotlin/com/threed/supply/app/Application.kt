package com.threed.supply.app

import com.threed.supply.app.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class Application : DaggerApplication()  {

    override fun applicationInjector(): AndroidInjector<Application> {
        return DaggerApplicationComponent.factory().create(this)
    }
}