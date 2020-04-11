package com.threed.supply.app.activity.di

import com.threed.supply.app.activity.main.MainActivity
import com.threed.supply.app.activity.main.di.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBinderModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    internal abstract fun bindMainActivity(): MainActivity
}