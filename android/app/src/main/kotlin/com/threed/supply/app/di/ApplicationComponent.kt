package com.threed.supply.app.di

import com.threed.supply.app.activity.di.ActivityBinderModule
import com.threed.supply.app.Application
import com.threed.supply.features.di.FragmentBinderModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@ApplicationScope
@Component(modules = [AndroidSupportInjectionModule::class, AppModule::class, ActivityBinderModule::class, FragmentBinderModule::class])
interface ApplicationComponent : AndroidInjector<Application> {

    @Component.Factory
    interface Factory : AndroidInjector.Factory<Application>
}
