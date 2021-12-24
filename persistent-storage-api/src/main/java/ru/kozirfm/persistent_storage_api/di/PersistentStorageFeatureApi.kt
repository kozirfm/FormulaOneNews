package ru.kozirfm.persistent_storage_api.di

import ru.kozirfm.persistent_storage_api.PersistentStorage

interface PersistentStorageFeatureApi {
    fun getPersistentStorage(): PersistentStorage
}