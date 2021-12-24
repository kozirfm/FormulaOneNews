package ru.kozirfm.news.di

import androidx.compose.material.ExperimentalMaterialApi
import dagger.Component
import ru.kozirfm.core_api.di.annotation.PerFeature
import ru.kozirfm.news.ui.NewsFragment

@PerFeature
@Component(
    modules = [NewsModule::class],
    dependencies = [NewsDependencies::class]
)
@ExperimentalMaterialApi
interface NewsComponent : NewsFeatureApi {
    fun inject(newsFragment: NewsFragment)
}