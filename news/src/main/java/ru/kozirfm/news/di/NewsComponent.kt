package ru.kozirfm.news.di

import dagger.Component
import ru.kozirfm.core.di.CoreDependencies
import ru.kozirfm.core.di.annotation.PerFeature
import ru.kozirfm.navigation_api.di.NavigationDependencies
import ru.kozirfm.network_api.di.NetworkDependencies
import ru.kozirfm.news.ui.NewsFragment

@PerFeature
@Component(
    modules = [NewsModule::class],
    dependencies = [CoreDependencies::class, NetworkDependencies::class, NavigationDependencies::class]
)
interface NewsComponent: NewsDependencies {
    fun inject(newsFragment: NewsFragment)
}