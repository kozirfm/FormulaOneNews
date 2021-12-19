package ru.kozirfm.persistent_storage.di

import dagger.Component
import ru.kozirfm.core_api.di.CoreDependencies
import ru.kozirfm.core_api.di.annotation.AppScope
import ru.kozirfm.persistent_storage_api.di.PersistentStorageDependencies

@AppScope
@Component(modules = [PersistentStorageModule::class], dependencies = [CoreDependencies::class])
interface PersistentStorageComponent: PersistentStorageDependencies