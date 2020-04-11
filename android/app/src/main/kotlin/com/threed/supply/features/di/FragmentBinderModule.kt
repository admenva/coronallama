package com.threed.supply.features.di

import com.threed.supply.features.institution.create.NewRequestFragment
import com.threed.supply.features.institution.create.di.NewRequestModule
import com.threed.supply.features.institution.main.InstitutionMainFragment
import com.threed.supply.features.institution.main.di.InstitutionMainModule
import com.threed.supply.features.institution.requests.InstitutionRequestsFragment
import com.threed.supply.features.institution.requests.di.InstitutionRequestsModule
import com.threed.supply.features.login.LoginFragment
import com.threed.supply.features.login.di.LoginFragmentModule
import com.threed.supply.features.messages.MessagesFragment
import com.threed.supply.features.messages.di.MessagesFragmentModule
import com.threed.supply.features.signup.SignUpFragment
import com.threed.supply.features.signup.di.SignupFragmentModule
import com.threed.supply.features.start.StartFragment
import com.threed.supply.features.start.di.StartFragmentModule
import com.threed.supply.features.volunteer.main.VolunteerMainFragment
import com.threed.supply.features.volunteer.main.di.VolunteerMainModule
import com.threed.supply.features.volunteer.request.confirmation.RequestConfirmationFragment
import com.threed.supply.features.volunteer.request.confirmation.di.RequestConfirmationModule
import com.threed.supply.features.volunteer.request.details.RequestDetailsFragment
import com.threed.supply.features.volunteer.request.details.di.RequestDetailsModule
import com.threed.supply.features.volunteer.request.list.VolunteerHomeFragment
import com.threed.supply.features.volunteer.request.list.di.VolunteerHomeModule
import com.threed.supply.features.volunteer.submissions.VolunteerSubmissionsFragment
import com.threed.supply.features.volunteer.submissions.di.VolunteerSubmissionsModule
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