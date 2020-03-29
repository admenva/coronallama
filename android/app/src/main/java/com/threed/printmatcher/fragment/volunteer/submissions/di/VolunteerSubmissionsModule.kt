package com.threed.printmatcher.fragment.volunteer.submissions.di

import com.threed.printmatcher.fragment.di.FragmentScope
import com.threed.printmatcher.fragment.volunteer.submissions.VolunteerSubmissionsFragment
import com.threed.printmatcher.fragment.volunteer.submissions.mvp.VolunteerSubmissionsContract
import com.threed.printmatcher.fragment.volunteer.submissions.mvp.VolunteerSubmissionsModel
import com.threed.printmatcher.fragment.volunteer.submissions.mvp.VolunteerSubmissionsPresenter
import com.threed.printmatcher.fragment.volunteer.submissions.mvp.VolunteerSubmissionsView
import com.threed.printmatcher.model.Submission
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class VolunteerSubmissionsModule {

    @Binds
    abstract fun view(view: VolunteerSubmissionsView): VolunteerSubmissionsContract.View

    @Binds
    abstract fun presenter(presenter: VolunteerSubmissionsPresenter): VolunteerSubmissionsContract.Presenter

    @Binds
    abstract fun model(model: VolunteerSubmissionsModel): VolunteerSubmissionsContract.Model

    @Module
    companion object {

        @Provides
        @JvmStatic
        @FragmentScope
        fun submission(fragment: VolunteerSubmissionsFragment): Submission {
            return fragment.arguments!!.getSerializable("submission") as Submission
        }
    }
}