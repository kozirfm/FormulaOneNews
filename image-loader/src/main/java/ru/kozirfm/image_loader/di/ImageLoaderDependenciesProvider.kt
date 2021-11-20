package ru.kozirfm.image_loader.di

import ru.kozirfm.core.di.CoreDependencies

object ImageLoaderDependenciesProvider {
    var coreDependencies: CoreDependencies? = null

    fun set(coreDependencies: CoreDependencies){
        this.coreDependencies = coreDependencies
    }
}