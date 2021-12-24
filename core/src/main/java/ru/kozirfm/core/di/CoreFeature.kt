package ru.kozirfm.core.di

import android.content.Context
import ru.kozirfm.core_api.di.CoreFeatureApi
import javax.inject.Inject

class CoreFeature @Inject constructor(context: Context) {

    private val _api: CoreFeatureApi by lazy {
        DaggerCoreComponent.builder()
            .context(context)
            .build()
            .also { coreComponent = it }
    }

    fun getApi() = _api

    internal companion object {
        var coreComponent: CoreComponent? = null
    }
}