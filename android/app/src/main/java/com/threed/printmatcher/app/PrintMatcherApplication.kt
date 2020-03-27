package com.threed.printmatcher.app

import com.threed.printmatcher.app.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class PrintMatcherApplication : DaggerApplication()  {

    override fun applicationInjector(): AndroidInjector<PrintMatcherApplication> {
        return DaggerApplicationComponent.factory().create(this)
    }
}