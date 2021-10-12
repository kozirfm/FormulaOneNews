package ru.kozirfm.formulaonenews.app

import android.app.Application
import ru.kozirfm.core.di.CoreDependenciesProvider
import ru.kozirfm.di.NavigationFeature
import ru.kozirfm.formulaonenews.di.ApplicationFeature
import ru.kozirfm.network.di.NetworkFeature
import ru.kozirfm.news.di.NewsDependenciesProvider

class App : Application() {

    private val applicationComponent = ApplicationFeature.getComponent(this)
    private val networkComponent = NetworkFeature.getComponent()
    private val navigationComponent = NavigationFeature.getComponent()

    override fun onCreate() {
        super.onCreate()
        CoreDependenciesProvider.set(navigationComponent)
        NewsDependenciesProvider.set(applicationComponent, networkComponent, navigationComponent)
    }

}