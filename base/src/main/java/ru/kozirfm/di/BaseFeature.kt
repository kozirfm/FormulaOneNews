package ru.kozirfm.di

object BaseFeature {
    fun getComponent(): BaseComponent {
        return DaggerBaseComponent
            .builder()
            .navigationDependencies(BaseDependenciesProvider.navigationDependencies)
            .build()
    }
}