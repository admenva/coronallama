package com.threed.printmatcher.fragment.di

import com.threed.printmatcher.fragment.home.VolunteerHomeFragment
import com.threed.printmatcher.fragment.home.VolunteerMainFragment
import com.threed.printmatcher.fragment.home.di.VolunteerHomeModule
import com.threed.printmatcher.fragment.home.di.VolunteerMainModule
import com.threed.printmatcher.fragment.login.LoginFragment
import com.threed.printmatcher.fragment.login.di.LoginFragmentModule
import com.threed.printmatcher.fragment.main.StartFragment
import com.threed.printmatcher.fragment.main.di.StartFragmentModule
import com.threed.printmatcher.fragment.request.confirmation.RequestConfirmationFragment
import com.threed.printmatcher.fragment.request.confirmation.di.RequestConfirmationModule
import com.threed.printmatcher.fragment.request.details.RequestDetailsFragment
import com.threed.printmatcher.fragment.request.details.di.RequestDetailsModule
import com.threed.printmatcher.fragment.signup.SignUpFragment
import com.threed.printmatcher.fragment.signup.di.SignupFragmentModule
import com.threed.printmatcher.fragment.submissions.institution.InstitutionSubmissionsFragment
import com.threed.printmatcher.fragment.submissions.institution.di.InstitutionSubmissionsModule
import com.threed.printmatcher.fragment.submissions.volunteer.VolunteerSubmissionsFragment
import com.threed.printmatcher.fragment.submissions.volunteer.di.VolunteerSubmissionsModule
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

    @ContributesAndroidInjector(modules = [RequestConfirmationModule::class])
    @FragmentScope
    abstract fun provideRequestConfirmationFragment(): RequestConfirmationFragment

    @ContributesAndroidInjector(modules = [VolunteerMainModule::class])
    @FragmentScope
    abstract fun provideVolunteerMainFragment(): VolunteerMainFragment

    @ContributesAndroidInjector(modules = [VolunteerSubmissionsModule::class])
    @FragmentScope
    abstract fun provideVolunteerSubmissionsFragment(): VolunteerSubmissionsFragment

    @ContributesAndroidInjector(modules = [InstitutionSubmissionsModule::class])
    @FragmentScope
    abstract fun provideInstitutionSubmissionsFragment(): InstitutionSubmissionsFragment
}