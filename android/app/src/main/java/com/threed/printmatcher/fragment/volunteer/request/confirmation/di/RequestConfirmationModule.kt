package com.threed.printmatcher.fragment.volunteer.request.confirmation.di

import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.threed.printmatcher.activity.main.AppViewModel
import com.threed.printmatcher.activity.main.MainActivity
import com.threed.printmatcher.fragment.di.FragmentScope
import com.threed.printmatcher.fragment.volunteer.request.confirmation.RequestConfirmationFragment
import com.threed.printmatcher.fragment.volunteer.request.confirmation.mvp.RequestConfirmationContract
import com.threed.printmatcher.fragment.volunteer.request.confirmation.mvp.RequestConfirmationPresenter
import com.threed.printmatcher.fragment.volunteer.request.confirmation.mvp.RequestConfirmationView
import com.threed.printmatcher.model.Submission
import com.threed.printmatcher.model.User
import com.threed.printmatcher.model.User.Volunteer
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