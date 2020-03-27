package com.threed.printmatcher.fragment.di

import com.threed.printmatcher.fragment.mainpage.MainPageFragment
import com.threed.printmatcher.fragment.mainpage.di.MainPageFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBinderModule {

    @ContributesAndroidInjector(modules = [MainPageFragmentModule::class])
    @FragmentScope
    abstract fun provideMainPageFragment(): MainPageFragment
}