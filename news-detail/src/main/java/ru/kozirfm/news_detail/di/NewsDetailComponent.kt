package ru.kozirfm.news_detail.di

import dagger.Component
import ru.kozirfm.core.annotation.PerFeature
import ru.kozirfm.news_detail.ui.NewsDetailFragment

@PerFeature
@Component(
    modules = [NewsDetailModule::class],
    dependencies = [NewsDetailDependencies::class]
)
interface NewsDetailComponent : NewsDetailFeatureApi {
    fun inject(fragment: NewsDetailFragment)
}