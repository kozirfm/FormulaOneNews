package ru.kozirfm.network.di

import ru.kozirfm.network_api.di.NetworkDependencies

object NetworkDependenciesProvider {

    var dependencies: NetworkDependencies? = null

    fun set(dependencies: NetworkDependencies) {
        this.dependencies = dependencies
    }
}