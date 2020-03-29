package com.threed.printmatcher.fragment.di

import com.threed.printmatcher.fragment.home.VolunteerHomeFragment
import com.threed.printmatcher.fragment.home.di.VolunteerHomeModule
import com.threed.printmatcher.fragment.login.LoginFragment
import com.threed.printmatcher.fragment.login.di.LoginFragmentModule
import com.threed.printmatcher.fragment.main.StartFragment
import com.threed.printmatcher.fragment.main.di.StartFragmentModule
import com.threed.printmatcher.fragment.requestdetails.RequestDetailsFragment
import com.threed.printmatcher.fragment.requestdetails.di.RequestDetailsModule
import com.threed.printmatcher.fragment.signup.SignUpFragment
import com.threed.printmatcher.fragment.signup.di.SignupFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBinderModule {

    @ContributesAndroidInjector(modules = [StartFragmentModule::class])
    @FragmentScope
    abstract fun provideStartFragment(): StartFragment

    @ContributesAndroidInjector(modules = [LoginFragmentModule::class])
    @FragmentScope
    abstract fun provideLoginFragment(): LoginFragment

    @ContributesAndroidInjector(modules = [SignupFragmentModule::class])
    @FragmentScope
    abstract fun provideSignUpFragment(): SignUpFragment

    @ContributesAndroidInjector(modules = [VolunteerHomeModule::class])
    @FragmentScope
    abstract fun provideVolunteerHomeFragment(): VolunteerHomeFragment

    @ContributesAndroidInjector(modules = [RequestDetailsModule::class])
    @FragmentScope
    abstract fun provideRequestDetailsFragment(): RequestDetailsFragment
}