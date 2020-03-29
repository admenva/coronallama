package com.threed.printmatcher.fragment.di

import com.threed.printmatcher.fragment.home.VolunteerHomeFragment
import com.threed.printmatcher.fragment.home.di.VolunteerHomeModule
import com.threed.printmatcher.fragment.main.StartFragment
import com.threed.printmatcher.fragment.requestdetails.RequestDetailsFragment
import com.threed.printmatcher.fragment.requestdetails.di.RequestDetailsModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBinderModule {

    @ContributesAndroidInjector
    @FragmentScope
    abstract fun provideMainPageFragment(): StartFragment

    @ContributesAndroidInjector(modules = [VolunteerHomeModule::class])
    @FragmentScope
    abstract fun provideVolunteerHomeFragment(): VolunteerHomeFragment

    @ContributesAndroidInjector(modules = [RequestDetailsModule::class])
    @FragmentScope
    abstract fun provideRequestDetailsFragment(): RequestDetailsFragment
}