package ru.kozirfm.core.di

import ru.kozirfm.navigation_api.di.NavigationDependencies

object CoreDependenciesProvider {

    var navigationDependencies: NavigationDependencies? = null

    fun set(navigationDependencies: NavigationDependencies) {
        this.navigationDependencies = navigationDependencies
    }
}