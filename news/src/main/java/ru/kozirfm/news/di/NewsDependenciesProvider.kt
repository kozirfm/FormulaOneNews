package ru.kozirfm.news.di

import ru.kozirfm.image_loader_api.di.ImageLoaderDependencies
import ru.kozirfm.navigation_api.di.NavigationDependencies
import ru.kozirfm.network_api.di.NetworkDependencies

object NewsDependenciesProvider {

    var networkDependencies: NetworkDependencies? = null
    var navigationDependencies: NavigationDependencies? = null
    var imageLoaderDependencies: ImageLoaderDependencies? = null

    fun set(
        networkDependencies: NetworkDependencies,
        navigationDependencies: NavigationDependencies,
        imageLoaderDependencies: ImageLoaderDependencies
    ) {
        this.networkDependencies = networkDependencies
        this.navigationDependencies = navigationDependencies
        this.imageLoaderDependencies = imageLoaderDependencies
    }
}