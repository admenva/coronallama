package com.threed.printmatcher.fragment.institution.requests.di

import com.threed.printmatcher.fragment.institution.requests.mvp.InstitutionRequestsContract
import com.threed.printmatcher.fragment.institution.requests.mvp.InstitutionRequestsModel
import com.threed.printmatcher.fragment.institution.requests.mvp.InstitutionRequestsPresenter
import com.threed.printmatcher.fragment.institution.requests.mvp.InstitutionRequestsView
import dagger.Binds
import dagger.Module

@Module
abstract class InstitutionRequestsModule {

    @Binds
    abstract fun view(view: InstitutionRequestsView): InstitutionRequestsContract.View

    @Binds
    abstract fun presenter(presenter: InstitutionRequestsPresenter): InstitutionRequestsContract.Presenter

    @Binds
    abstract fun model(model: InstitutionRequestsModel): InstitutionRequestsContract.Model
}