package com.threed.printmatcher.app.di

import com.threed.printmatcher.activity.di.ActivityBinderModule
import com.threed.printmatcher.app.Application
import com.threed.printmatcher.features.di.FragmentBinderModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@ApplicationScope
@Component(modules = [AndroidSupportInjectionModule::class, AppModule::class, ActivityBinderModule::class, FragmentBinderModule::class])
interface ApplicationComponent : AndroidInjector<Application> {

    @Component.Factory
    interface Factory : AndroidInjector.Factory<Application>
}
