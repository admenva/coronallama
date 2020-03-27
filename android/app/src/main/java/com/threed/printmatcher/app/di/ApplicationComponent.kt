package com.threed.printmatcher.app.di

import com.threed.printmatcher.activity.di.ActivityBinderModule
import com.threed.printmatcher.app.PrintMatcherApplication
import com.threed.printmatcher.fragment.di.FragmentBinderModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@ApplicationScope
@Component(modules = [AndroidSupportInjectionModule::class, AppModule::class, ActivityBinderModule::class, FragmentBinderModule::class])
interface ApplicationComponent : AndroidInjector<PrintMatcherApplication> {

    @Component.Factory
    interface Factory : AndroidInjector.Factory<PrintMatcherApplication>
}
