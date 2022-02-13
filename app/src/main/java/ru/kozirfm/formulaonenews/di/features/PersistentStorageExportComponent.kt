package ru.kozirfm.formulaonenews.di.features

import dagger.Component
import ru.kozirfm.core.di.BaseDependencies
import ru.kozirfm.persistent_storage.di.PersistentStorageDependencies

@Component(dependencies = [BaseDependencies::class])
interface PersistentStorageExportComponent : PersistentStorageDependencies