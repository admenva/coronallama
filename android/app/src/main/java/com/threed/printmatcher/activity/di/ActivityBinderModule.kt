package com.threed.printmatcher.activity.di

import com.threed.printmatcher.activity.main.MainActivity
import com.threed.printmatcher.activity.main.di.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBinderModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    internal abstract fun bindMainActivity(): MainActivity
}