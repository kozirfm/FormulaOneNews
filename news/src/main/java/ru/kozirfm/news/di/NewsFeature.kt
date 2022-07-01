package ru.kozirfm.news.di

import ru.kozirfm.core.annotation.AppScope
import ru.kozirfm.core.base.ScreenFeature
import ru.kozirfm.core.screens.Screen
import javax.inject.Inject

@AppScope
class NewsFeature @Inject constructor(dependencies: NewsDependencies) : ScreenFeature<NewsFeatureApi> {

    private val _api: NewsFeatureApi by lazy {
        DaggerNewsComponent
            .builder()
            .newsDependencies(dependencies)
            .build()
            .also { newsComponent = it }
    }

    override fun getApi() = _api
    override fun getScreenName(): String = NEWS_SCREEN

    companion object {
        val NEWS_SCREEN = Screen.NEWS.name
        var newsComponent: NewsComponent? = null
    }
}