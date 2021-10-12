package ru.kozirfm.core.di

object CoreFeature {
    fun getComponent(): CoreComponent {
        return DaggerCoreComponent
            .builder()
            .navigationDependencies(CoreDependenciesProvider.navigationDependencies)
            .build()
    }
}