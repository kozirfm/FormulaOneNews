package ru.kozirfm.firebase.di

import dagger.Component
import ru.kozirfm.core_api.di.CoreDependencies
import ru.kozirfm.di.annotation.AppScope
import ru.kozirfm.firebase.FirebaseService
import ru.kozirfm.firebase_api.di.FirebaseDependencies

@ru.kozirfm.di.annotation.AppScope
@Component(modules = [FirebaseModule::class], dependencies = [CoreDependencies::class])
interface FirebaseComponent : FirebaseDependencies {
    fun inject(service: FirebaseService)
}