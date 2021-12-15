package ru.kozirfm.core.di

import dagger.Binds
import dagger.Module
import ru.kozirfm.core.preference.PersistentStorageImpl
import ru.kozirfm.core_api.preferences.PersistentStorage
import ru.kozirfm.di.annotation.AppScope

@Module
interface CoreModule {

    @Binds
    @AppScope
    fun bindPersistentStorage(impl: PersistentStorageImpl): PersistentStorage
}