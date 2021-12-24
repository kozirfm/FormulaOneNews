package ru.kozirfm.news.di

import androidx.compose.material.ExperimentalMaterialApi
import ru.kozirfm.core_api.di.annotation.AppScope
import javax.inject.Inject

@AppScope
@ExperimentalMaterialApi
class NewsFeature @Inject constructor(dependencies: NewsDependencies) {

    private val _api: NewsFeatureApi =
        DaggerNewsComponent
            .builder()
            .newsDependencies(dependencies)
            .build()
            .also { newsComponent = it }

    fun getApi() = _api

    internal companion object {
        var newsComponent: NewsComponent? = null
    }
}