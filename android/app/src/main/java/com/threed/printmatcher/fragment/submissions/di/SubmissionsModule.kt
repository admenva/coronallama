package com.threed.printmatcher.fragment.submissions.di

import com.threed.printmatcher.fragment.di.FragmentScope
import com.threed.printmatcher.fragment.submissions.SubmissionsFragment
import com.threed.printmatcher.fragment.submissions.mvp.SubmissionsContract
import com.threed.printmatcher.fragment.submissions.mvp.SubmissionsModel
import com.threed.printmatcher.fragment.submissions.mvp.SubmissionsPresenter
import com.threed.printmatcher.fragment.submissions.mvp.SubmissionsView
import com.threed.printmatcher.model.Submission
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class SubmissionsModule {

    @Binds
    abstract fun view(view: SubmissionsView): SubmissionsContract.View

    @Binds
    abstract fun presenter(presenter: SubmissionsPresenter): SubmissionsContract.Presenter

    @Binds
    abstract fun model(model: SubmissionsModel): SubmissionsContract.Model

    @Module
    companion object {

        @Provides
        @JvmStatic
        @FragmentScope
        fun submission(fragment: SubmissionsFragment): Submission {
            return fragment.arguments!!.getSerializable("submission") as Submission
        }
    }
}