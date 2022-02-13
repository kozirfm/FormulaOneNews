package ru.kozirfm.core.di

import javax.inject.Inject

class CoreFeature @Inject constructor(dependencies: CoreDependencies) {

    private val _api: CoreFeatureApi by lazy {
        DaggerCoreComponent.builder()
            .coreDependencies(dependencies)
            .build()
            .also { coreComponent = it }
    }

    fun getApi() = _api

    internal companion object {
        var coreComponent: CoreComponent? = null
    }
}