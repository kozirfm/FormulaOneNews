package ru.kozirfm.formulaonenews.di

import androidx.compose.material.ExperimentalMaterialApi
import dagger.Component
import ru.kozirfm.core_api.di.annotation.AppScope
import ru.kozirfm.di.BaseFeature
import ru.kozirfm.login.di.LoginFeature
import ru.kozirfm.news.di.NewsFeature

@AppScope
@ExperimentalMaterialApi
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun getBaseFeature(): BaseFeature
    fun getNewsFeature(): NewsFeature
    fun getLoginFeature(): LoginFeature
}