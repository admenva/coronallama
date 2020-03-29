package com.threed.printmatcher.fragment.volunteer.request.list.di

import com.threed.printmatcher.fragment.volunteer.request.list.mvp.VolunteerHomeContract
import com.threed.printmatcher.fragment.volunteer.request.list.mvp.VolunteerHomeModel
import com.threed.printmatcher.fragment.volunteer.request.list.mvp.VolunteerHomePresenter
import com.threed.printmatcher.fragment.volunteer.request.list.mvp.VolunteerHomeView
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