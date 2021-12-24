package ru.kozirfm.formulaonenews.di.features

import dagger.Component
import ru.kozirfm.core_api.di.CoreFeatureApi
import ru.kozirfm.persistent_storage.di.PersistentStorageDependencies

@Component(dependencies = [CoreFeatureApi::class])
interface PersistentStorageExportComponent : PersistentStorageDependencies