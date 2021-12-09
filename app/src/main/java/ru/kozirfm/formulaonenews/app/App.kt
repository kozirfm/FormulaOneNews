package ru.kozirfm.formulaonenews.app

import android.app.Application
import com.google.firebase.messaging.FirebaseMessaging
import ru.kozirfm.core.di.CoreDependenciesProvider
import ru.kozirfm.di.NavigationFeature
import ru.kozirfm.image_loader.di.ImageLoaderFeature
import ru.kozirfm.login.di.LoginDependenciesProvider
import ru.kozirfm.network.di.NetworkFeature
import ru.kozirfm.news.di.NewsDependenciesProvider

class App : Application() {

    private val imageLoaderComponent = ImageLoaderFeature.getComponent()
    private val networkComponent = NetworkFeature.getComponent()
    private val navigationComponent = NavigationFeature.getComponent()

    override fun onCreate() {
        super.onCreate()
//        FirebaseMessaging.getInstance().subscribeToTopic("all")
        CoreDependenciesProvider.set(navigationComponent)
        LoginDependenciesProvider.set(networkComponent, navigationComponent)
        NewsDependenciesProvider.set(networkComponent, navigationComponent)
    }

}
