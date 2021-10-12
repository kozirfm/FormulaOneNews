package ru.kozirfm.news.di

import ru.kozirfm.core.di.CoreDependencies
import ru.kozirfm.navigation_api.di.NavigationDependencies
import ru.kozirfm.network_api.di.NetworkDependencies

object NewsDependenciesProvider {

    var networkDependencies: NetworkDependencies? = null
    var navigationDependencies: NavigationDependencies? = null
    var coreDependencies: CoreDependencies? = null

    fun set(
        coreDependencies: CoreDependencies,
        networkDependencies: NetworkDependencies,
        navigationDependencies: NavigationDependencies,
    ) {
        this.coreDependencies = coreDependencies
        this.networkDependencies = networkDependencies
        this.navigationDependencies = navigationDependencies
    }
}