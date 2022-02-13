package ru.kozirfm.firebase.di

import ru.kozirfm.core.annotation.AppScope
import ru.kozirfm.firebase_api.di.FirebaseFeatureApi
import javax.inject.Inject

@AppScope
class FirebaseFeature @Inject constructor(dependencies: FirebaseDependencies) {

    private val _api: FirebaseFeatureApi by lazy {
        DaggerFirebaseComponent.builder()
            .firebaseDependencies(dependencies)
            .build()
            .also { firebaseComponent = it }
    }

    fun getApi() = _api

    internal companion object {
        var firebaseComponent: FirebaseComponent? = null
    }
}