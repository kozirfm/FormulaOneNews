package ru.kozirfm.firebase.di

import dagger.Component
import ru.kozirfm.core_api.di.annotation.AppScope
import ru.kozirfm.firebase.FirebaseService
import ru.kozirfm.firebase_api.di.FirebaseFeatureApi

@AppScope
@Component(
    modules = [FirebaseModule::class],
    dependencies = [FirebaseDependencies::class]
)
interface FirebaseComponent : FirebaseFeatureApi {
    fun inject(service: FirebaseService)
}