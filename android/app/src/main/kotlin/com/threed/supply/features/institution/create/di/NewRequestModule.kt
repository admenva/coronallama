package com.threed.supply.features.institution.create.di

import com.threed.supply.features.institution.create.mvp.NewRequestContract
import com.threed.supply.features.institution.create.mvp.NewRequestPresenter
import com.threed.supply.features.institution.create.mvp.NewRequestView
import dagger.Binds
import dagger.Module

@Module
abstract class NewRequestModule {

    @Binds
    abstract fun view(view: NewRequestView): NewRequestContract.View

    @Binds
    abstract fun presenter(presenter: NewRequestPresenter): NewRequestContract.Presenter

}