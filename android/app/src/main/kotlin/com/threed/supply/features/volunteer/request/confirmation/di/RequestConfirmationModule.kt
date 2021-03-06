package com.threed.supply.features.volunteer.request.confirmation.di

import androidx.activity.viewModels
import com.threed.supply.app.activity.main.AppViewModel
import com.threed.supply.features.di.FragmentScope
import com.threed.supply.features.volunteer.request.confirmation.RequestConfirmationFragment
import com.threed.supply.features.volunteer.request.confirmation.mvp.RequestConfirmationContract
import com.threed.supply.features.volunteer.request.confirmation.mvp.RequestConfirmationPresenter
import com.threed.supply.features.volunteer.request.confirmation.mvp.RequestConfirmationView
import com.threed.supply.libs.model.Submission
import com.threed.supply.libs.model.User.Volunteer
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class RequestConfirmationModule {

    @Binds
    abstract fun view(view: RequestConfirmationView): RequestConfirmationContract.View

    @Binds
    abstract fun presenter(presenter: RequestConfirmationPresenter): RequestConfirmationContract.Presenter

    @Module
    companion object {
        @Provides
        @JvmStatic
        @FragmentScope
        fun submission(fragment: RequestConfirmationFragment): Submission {
            return fragment.arguments!!.getSerializable("submission") as Submission
        }

        @Provides
        @JvmStatic
        @FragmentScope
        fun user(fragment: RequestConfirmationFragment): Volunteer {
            return fragment.activity?.viewModels<AppViewModel>()?.value?.getUser()?.value as Volunteer
        }
    }
}