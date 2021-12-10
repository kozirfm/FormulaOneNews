package ru.kozirfm.news.di

import androidx.compose.material.ExperimentalMaterialApi

@ExperimentalMaterialApi
object NewsFeature {
    fun getComponent(): NewsComponent {
        return DaggerNewsComponent
            .builder()
            .networkDependencies(NewsDependenciesProvider.networkDependencies)
            .navigationDependencies(NewsDependenciesProvider.navigationDependencies)
            .imageLoaderDependencies(NewsDependenciesProvider.imageLoaderDependencies)
            .build()
    }
}