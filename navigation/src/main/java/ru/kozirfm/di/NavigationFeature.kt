package ru.kozirfm.di

import ru.kozirfm.navigation_api.di.NavigationFeatureApi
import javax.inject.Inject

class NavigationFeature @Inject constructor() {

    private val _api: NavigationFeatureApi = DaggerNavigationComponent
        .create()
        .also { navigationComponent = it }

    fun getApi() = _api

    internal companion object {
        var navigationComponent: NavigationComponent? = null
    }
}