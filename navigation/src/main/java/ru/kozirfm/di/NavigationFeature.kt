package ru.kozirfm.di

import ru.kozirfm.navigation_api.di.NavigationFeatureApi
import javax.inject.Inject

class NavigationFeature @Inject constructor(dependencies: NavigationDependencies) {

    private val _api: NavigationFeatureApi by lazy {
        DaggerNavigationComponent.builder()
            .navigationDependencies(dependencies)
            .build()
            .also { navigationComponent = it }
    }

    fun getApi() = _api

    internal companion object {
        var navigationComponent: NavigationComponent? = null
    }
}