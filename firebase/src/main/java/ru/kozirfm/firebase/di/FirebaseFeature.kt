package ru.kozirfm.firebase.di

object FirebaseFeature {
    fun getComponent(): FirebaseComponent {
        return DaggerFirebaseComponent
            .builder()
            .coreDependencies(FirebaseDependenciesProvider.coreDependencies)
            .build()
    }
}