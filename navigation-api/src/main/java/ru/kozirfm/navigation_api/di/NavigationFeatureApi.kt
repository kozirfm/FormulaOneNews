package ru.kozirfm.navigation_api.di

import ru.kozirfm.navigation_api.NavigationController
import ru.kozirfm.navigation_api.NavigateRootDirection

interface NavigationFeatureApi {
    fun getNavigation(): NavigationController
    fun getRootDirections(): NavigateRootDirection
}