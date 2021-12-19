package ru.kozirfm.firebase.di

import dagger.Component
import ru.kozirfm.core_api.di.annotation.AppScope
import ru.kozirfm.firebase.FirebaseService
import ru.kozirfm.firebase_api.di.FirebaseDependencies
import ru.kozirfm.persistent_storage_api.di.PersistentStorageDependencies

@AppScope
@Component(modules = [FirebaseModule::class], dependencies = [PersistentStorageDependencies::class])
interface FirebaseComponent : FirebaseDependencies {
    fun inject(service: FirebaseService)
}