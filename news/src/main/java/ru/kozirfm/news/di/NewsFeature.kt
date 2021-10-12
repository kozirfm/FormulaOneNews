package ru.kozirfm.news.di

object NewsFeature {
    fun getComponent(): NewsComponent {
        return DaggerNewsComponent
            .builder()
            .coreDependencies(NewsDependenciesProvider.coreDependencies)
            .networkDependencies(NewsDependenciesProvider.networkDependencies)
            .navigationDependencies(NewsDependenciesProvider.navigationDependencies)
            .build()
    }
}