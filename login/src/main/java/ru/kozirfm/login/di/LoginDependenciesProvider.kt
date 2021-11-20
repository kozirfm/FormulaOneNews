package ru.kozirfm.login.di

import ru.kozirfm.navigation_api.di.NavigationDependencies
import ru.kozirfm.network_api.di.NetworkDependencies

object LoginDependenciesProvider {

    var networkDependencies: NetworkDependencies? = null
    var navigationDependencies: NavigationDependencies? = null

    fun set(
        networkDependencies: NetworkDependencies,
        navigationDependencies: NavigationDependencies,
    ) {
        this.networkDependencies = networkDependencies
        this.navigationDependencies = navigationDependencies
    }
}