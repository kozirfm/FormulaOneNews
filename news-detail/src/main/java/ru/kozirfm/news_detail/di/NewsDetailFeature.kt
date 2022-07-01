package ru.kozirfm.news_detail.di

import ru.kozirfm.core.annotation.AppScope
import ru.kozirfm.core.base.ScreenFeature
import ru.kozirfm.core.screens.Screen
import javax.inject.Inject

@AppScope
class NewsDetailFeature @Inject constructor(dependencies: NewsDetailDependencies) : ScreenFeature<NewsDetailFeatureApi> {

    private val _api: NewsDetailFeatureApi by lazy {
        DaggerNewsDetailComponent.builder()
            .newsDetailDependencies(dependencies)
            .build()
            .also { newsDetailComponent = it }
    }

    override fun getApi() = _api

    override fun getScreenName(): String = Screen.NEWS_DETAIL.name

    internal companion object {
        var newsDetailComponent: NewsDetailComponent? = null
    }

}