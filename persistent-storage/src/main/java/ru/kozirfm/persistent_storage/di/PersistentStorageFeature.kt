package ru.kozirfm.persistent_storage.di

object PersistentStorageFeature {
    fun getComponent(): PersistentStorageComponent {
        return DaggerPersistentStorageComponent
            .builder()
            .coreDependencies(PersistentStorageDependenciesProvider.coreDependencies)
            .build()
    }
}