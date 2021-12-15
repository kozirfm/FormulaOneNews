package ru.kozirfm.firebase.di

import ru.kozirfm.persistent_storage_api.di.PersistentStorageDependencies

object FirebaseDependenciesProvider {

    var persistentStorageDependencies: PersistentStorageDependencies? = null

    fun set(persistentStorageDependencies: PersistentStorageDependencies) {
        this.persistentStorageDependencies = persistentStorageDependencies
    }
}