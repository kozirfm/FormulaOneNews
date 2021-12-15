package ru.kozirfm.login.di

import ru.kozirfm.firebase_api.di.FirebaseDependencies
import ru.kozirfm.navigation_api.di.NavigationDependencies
import ru.kozirfm.network_api.di.NetworkDependencies

object LoginDependenciesProvider {

    var networkDependencies: NetworkDependencies? = null
    var navigationDependencies: NavigationDependencies? = null
    var firebaseDependencies: FirebaseDependencies? = null

    fun set(
        networkDependencies: NetworkDependencies,
        navigationDependencies: NavigationDependencies,
        firebaseDependencies: FirebaseDependencies
    ) {
        this.networkDependencies = networkDependencies
        this.navigationDependencies = navigationDependencies
        this.firebaseDependencies = firebaseDependencies
    }
}