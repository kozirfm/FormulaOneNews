package ru.kozirfm.di

import ru.kozirfm.navigation_api.di.NavigationDependencies

object BaseDependenciesProvider {

    var navigationDependencies: NavigationDependencies? = null

    fun set(navigationDependencies: NavigationDependencies) {
        this.navigationDependencies = navigationDependencies
    }
}