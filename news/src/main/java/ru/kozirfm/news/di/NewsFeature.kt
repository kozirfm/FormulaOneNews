package ru.kozirfm.news.di

object NewsFeature {
    fun getComponent(): NewsComponent {
        return DaggerNewsComponent
            .builder()
            .networkDependencies(NewsDependenciesProvider.networkDependencies)
            .navigationDependencies(NewsDependenciesProvider.navigationDependencies)
            .build()
    }
}