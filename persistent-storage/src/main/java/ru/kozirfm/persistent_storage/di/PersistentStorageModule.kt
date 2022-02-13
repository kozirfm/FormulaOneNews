package ru.kozirfm.persistent_storage.di

import dagger.Binds
import dagger.Module
import ru.kozirfm.core.annotation.AppScope
import ru.kozirfm.persistent_storage.PersistentStorageImpl
import ru.kozirfm.persistent_storage_api.PersistentStorage

@Module
interface PersistentStorageModule {

    @Binds
    @AppScope
    fun bindPersistentStorage(impl: PersistentStorageImpl): PersistentStorage
}