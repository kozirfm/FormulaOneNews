package ru.kozirfm.formulaonenews.di.features

import dagger.Component
import ru.kozirfm.firebase.di.FirebaseDependencies
import ru.kozirfm.persistent_storage_api.di.PersistentStorageFeatureApi

@Component(dependencies = [PersistentStorageFeatureApi::class])
interface FirebaseExportComponent : FirebaseDependencies