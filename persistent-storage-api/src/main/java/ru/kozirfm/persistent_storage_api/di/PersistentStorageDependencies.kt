package ru.kozirfm.persistent_storage_api.di

import ru.kozirfm.persistent_storage_api.PersistentStorage

interface PersistentStorageDependencies {
    fun getPersistentStorage(): PersistentStorage
}