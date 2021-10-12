package ru.kozirfm.formulaonenews.di

import android.app.Application

object ApplicationFeature {

    fun getComponent(application: Application): ApplicationComponent {
        return DaggerApplicationComponent
            .builder()
            .application(application)
            .build()
    }

}
