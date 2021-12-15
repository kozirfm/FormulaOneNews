package ru.kozirfm.persistent_storage.di

import ru.kozirfm.core_api.di.CoreDependencies

object PersistentStorageDependenciesProvider {

    var coreDependencies: CoreDependencies? = null

    fun set(coreDependencies: CoreDependencies) {
        this.coreDependencies = coreDependencies
    }
}