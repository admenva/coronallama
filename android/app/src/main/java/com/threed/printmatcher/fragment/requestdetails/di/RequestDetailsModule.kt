package com.threed.printmatcher.fragment.requestdetails.di

import com.threed.printmatcher.fragment.di.FragmentScope
import com.threed.printmatcher.fragment.requestdetails.RequestDetailsFragment
import com.threed.printmatcher.fragment.requestdetails.mvp.RequestDetailsContract
import com.threed.printmatcher.fragment.requestdetails.mvp.RequestDetailsPresenter
import com.threed.printmatcher.fragment.requestdetails.mvp.RequestDetailsView
import com.threed.printmatcher.model.Request
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class RequestDetailsModule {

    @Binds
    abstract fun view(view: RequestDetailsView): RequestDetailsContract.View

    @Binds
    abstract fun presenter(presenter: RequestDetailsPresenter): RequestDetailsContract.Presenter

    @Module
    companion object {

        @Provides
        @JvmStatic
        @FragmentScope
        fun request(fragment: RequestDetailsFragment): Request {
            return fragment.arguments!!.getSerializable("request") as Request
        }
    }
}