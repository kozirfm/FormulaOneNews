package ru.kozirfm.persistent_storage.di

import ru.kozirfm.core.annotation.AppScope
import ru.kozirfm.persistent_storage_api.di.PersistentStorageFeatureApi
import javax.inject.Inject

@AppScope
class PersistentStorageFeature
@Inject constructor(
    dependencies: PersistentStorageDependencies
) {

    private val _api: PersistentStorageFeatureApi by lazy {
        DaggerPersistentStorageComponent.builder()
            .persistentStorageDependencies(dependencies)
            .build()
            .also { persistentStorageComponent = it }
    }

    fun getApi() = _api

    internal companion object {
        var persistentStorageComponent: PersistentStorageComponent? = null
    }
}