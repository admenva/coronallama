package com.threed.printmatcher.fragment.submissions.institution.di

import com.threed.printmatcher.fragment.submissions.institution.mvp.InstitutionSubmissionsContract
import com.threed.printmatcher.fragment.submissions.institution.mvp.InstitutionSubmissionsModel
import com.threed.printmatcher.fragment.submissions.institution.mvp.InstitutionSubmissionsPresenter
import com.threed.printmatcher.fragment.submissions.institution.mvp.InstitutionSubmissionsView
import dagger.Binds
import dagger.Module

@Module
abstract class InstitutionSubmissionsModule {

    @Binds
    abstract fun view(view: InstitutionSubmissionsView): InstitutionSubmissionsContract.View

    @Binds
    abstract fun presenter(presenter: InstitutionSubmissionsPresenter): InstitutionSubmissionsContract.Presenter

    @Binds
    abstract fun model(model: InstitutionSubmissionsModel): InstitutionSubmissionsContract.Model
}