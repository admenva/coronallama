package com.threed.printmatcher.fragment.request.confirmation.di

import com.threed.printmatcher.fragment.di.FragmentScope
import com.threed.printmatcher.fragment.request.confirmation.RequestConfirmationFragment
import com.threed.printmatcher.fragment.request.confirmation.mvp.RequestConfirmationContract
import com.threed.printmatcher.fragment.request.confirmation.mvp.RequestConfirmationPresenter
import com.threed.printmatcher.fragment.request.confirmation.mvp.RequestConfirmationView
import com.threed.printmatcher.model.Submission
import com.threed.printmatcher.model.User
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
        fun user(): User.Volunteer {
            return User.Volunteer(
                "Gianluca",
                "Portellini",
                "example@email.com",
                "1174 Budapest, Rakoczi Ferenc utca 89"
            )
        }
    }
}