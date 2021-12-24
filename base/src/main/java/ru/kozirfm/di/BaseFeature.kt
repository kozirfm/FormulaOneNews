package ru.kozirfm.di

import javax.inject.Inject

class BaseFeature @Inject constructor(dependencies: BaseDependencies) {

    private val _api: BaseFeatureApi by lazy {
        DaggerBaseComponent
            .builder()
            .baseDependencies(dependencies)
            .build()
            .also { baseComponent = it }
    }

    fun getApi() = _api

    internal companion object {
        var baseComponent: BaseComponent? = null
    }
}