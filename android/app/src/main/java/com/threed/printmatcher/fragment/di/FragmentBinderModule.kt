package com.threed.printmatcher.fragment.di

import com.threed.printmatcher.fragment.institution.create.NewRequestFragment
import com.threed.printmatcher.fragment.institution.create.di.NewRequestModule
import com.threed.printmatcher.fragment.institution.main.InstitutionMainFragment
import com.threed.printmatcher.fragment.institution.main.di.InstitutionMainModule
import com.threed.printmatcher.fragment.institution.requests.InstitutionRequestsFragment
import com.threed.printmatcher.fragment.institution.requests.di.InstitutionRequestsModule
import com.threed.printmatcher.fragment.login.LoginFragment
import com.threed.printmatcher.fragment.login.di.LoginFragmentModule
import com.threed.printmatcher.fragment.messages.MessagesFragment
import com.threed.printmatcher.fragment.messages.di.MessagesFragmentModule
import com.threed.printmatcher.fragment.signup.SignUpFragment
import com.threed.printmatcher.fragment.signup.di.SignupFragmentModule
import com.threed.printmatcher.fragment.start.StartFragment
import com.threed.printmatcher.fragment.start.di.StartFragmentModule
import com.threed.printmatcher.fragment.volunteer.main.VolunteerMainFragment
import com.threed.printmatcher.fragment.volunteer.main.di.VolunteerMainModule
import com.threed.printmatcher.fragment.volunteer.request.confirmation.RequestConfirmationFragment
import com.threed.printmatcher.fragment.volunteer.request.confirmation.di.RequestConfirmationModule
import com.threed.printmatcher.fragment.volunteer.request.details.RequestDetailsFragment
import com.threed.printmatcher.fragment.volunteer.request.details.di.RequestDetailsModule
import com.threed.printmatcher.fragment.volunteer.request.list.VolunteerHomeFragment
import com.threed.printmatcher.fragment.volunteer.request.list.di.VolunteerHomeModule
import com.threed.printmatcher.fragment.volunteer.submissions.VolunteerSubmissionsFragment
import com.threed.printmatcher.fragment.volunteer.submissions.di.VolunteerSubmissionsModule
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

    @ContributesAndroidInjector(modules = [InstitutionRequestsModule::class])
    @FragmentScope
    abstract fun provideInstitutionRequestsFragment(): InstitutionRequestsFragment

    @ContributesAndroidInjector(modules = [InstitutionMainModule::class])
    @FragmentScope
    abstract fun provideInstitutionMainFragment(): InstitutionMainFragment

    @ContributesAndroidInjector(modules = [MessagesFragmentModule::class])
    @FragmentScope
    abstract fun provideMessagesFragment(): MessagesFragment

    @ContributesAndroidInjector(modules = [NewRequestModule::class])
    @FragmentScope
    abstract fun provideCreateRequestFragment(): NewRequestFragment

}