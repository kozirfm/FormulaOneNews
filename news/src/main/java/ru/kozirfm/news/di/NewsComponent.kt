package ru.kozirfm.news.di

import dagger.Component
import ru.kozirfm.core.annotation.PerFeature
import ru.kozirfm.news.ui.NewsFragment

@PerFeature
@Component(
    modules = [NewsModule::class],
    dependencies = [NewsDependencies::class]
)
interface NewsComponent : NewsFeatureApi {
    fun inject(newsFragment: NewsFragment)
}