package ru.kozirfm.persistent_storage.di

import dagger.Component
import ru.kozirfm.core_api.di.annotation.AppScope
import ru.kozirfm.persistent_storage_api.di.PersistentStorageFeatureApi

@AppScope
@Component(
    modules = [PersistentStorageModule::class],
    dependencies = [PersistentStorageDependencies::class]
)
interface PersistentStorageComponent : PersistentStorageFeatureApi