package com.threed.printmatcher.fragment.home.di

import com.threed.printmatcher.fragment.home.mvp.VolunteerHomeContract
import com.threed.printmatcher.fragment.home.mvp.VolunteerHomeModel
import com.threed.printmatcher.fragment.home.mvp.VolunteerHomePresenter
import com.threed.printmatcher.fragment.home.mvp.VolunteerHomeView
import dagger.Binds
import dagger.Module

@Module
abstract class VolunteerHomeModule {

    @Binds
    abstract fun view(view: VolunteerHomeView): VolunteerHomeContract.View

    @Binds
    abstract fun presenter(presenter: VolunteerHomePresenter): VolunteerHomeContract.Presenter

    @Binds
    abstract fun model(model: VolunteerHomeModel): VolunteerHomeContract.Model
}