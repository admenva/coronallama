package com.threed.printmatcher.app.di

import android.content.Context
import android.content.res.Resources
import com.threed.printmatcher.app.PrintMatcherApplication
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class AppModule {

    @Binds
    internal abstract fun context(application: PrintMatcherApplication): Context

    @Module
    companion object {

        @Provides
        @JvmStatic
        internal fun resources(application: PrintMatcherApplication): Resources {
            return application.resources
        }
    }
}
