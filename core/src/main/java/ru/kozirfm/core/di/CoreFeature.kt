package ru.kozirfm.core.di

import android.content.Context

object CoreFeature {
    fun getComponent(context: Context): CoreComponent {
        return DaggerCoreComponent
            .builder()
            .context(context)
            .build()
    }
}