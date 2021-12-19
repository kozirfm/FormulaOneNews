package ru.kozirfm.news.di

import androidx.compose.material.ExperimentalMaterialApi
import dagger.Component
import ru.kozirfm.core_api.di.annotation.PerFeature
import ru.kozirfm.image_loader_api.di.ImageLoaderDependencies
import ru.kozirfm.navigation_api.di.NavigationDependencies
import ru.kozirfm.network_api.di.NetworkDependencies
import ru.kozirfm.news.ui.NewsFragment

@PerFeature
@Component(
    modules = [NewsModule::class],
    dependencies = [
        NetworkDependencies::class,
        NavigationDependencies::class,
        ImageLoaderDependencies::class
    ]
)
@ExperimentalMaterialApi
interface NewsComponent : NewsDependencies {
    fun inject(newsFragment: NewsFragment)
}