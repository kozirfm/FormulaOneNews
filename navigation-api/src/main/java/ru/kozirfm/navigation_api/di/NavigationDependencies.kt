package ru.kozirfm.navigation_api.di

import ru.kozirfm.navigation_api.NavigationController
import ru.kozirfm.navigation_api.RootDirections

interface NavigationDependencies {
    fun getNavigation(): NavigationController
    fun getRootDirections(): RootDirections
}