package ru.kozirfm.firebase.di

import ru.kozirfm.core_api.di.CoreDependencies

object FirebaseDependenciesProvider {

    var coreDependencies: CoreDependencies? = null

    fun set(coreDependencies: CoreDependencies) {
        this.coreDependencies = coreDependencies
    }
}