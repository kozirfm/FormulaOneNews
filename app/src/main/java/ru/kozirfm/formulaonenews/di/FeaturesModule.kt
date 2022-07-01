package ru.kozirfm.formulaonenews.di

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoSet
import ru.kozirfm.calendar.di.CalendarFeature
import ru.kozirfm.core.base.ScreenFeature
import ru.kozirfm.login.di.LoginFeature
import ru.kozirfm.news.di.NewsFeature
import ru.kozirfm.news_detail.di.NewsDetailFeature

@Module
interface FeaturesModule {

    @Binds
    @IntoSet
    fun bindNewsFeature(feature: NewsFeature): ScreenFeature<*>

    @Binds
    @IntoSet
    fun bindLoginFeature(feature: LoginFeature): ScreenFeature<*>

    @Binds
    @IntoSet
    fun bindNewsDetailFeature(feature: NewsDetailFeature): ScreenFeature<*>

    @Binds
    @IntoSet
    fun bindCalendarFeature(feature: CalendarFeature): ScreenFeature<*>

}