package ru.kozirfm.formulaonenews.app

import android.app.Application
import ru.kozirfm.core.di.CoreFeature
import ru.kozirfm.di.BaseDependenciesProvider
import ru.kozirfm.di.NavigationFeature
import ru.kozirfm.firebase.di.FirebaseDependenciesProvider
import ru.kozirfm.firebase.di.FirebaseFeature
import ru.kozirfm.image_loader.di.ImageLoaderFeature
import ru.kozirfm.login.di.LoginDependenciesProvider
import ru.kozirfm.network.di.NetworkFeature
import ru.kozirfm.news.di.NewsDependenciesProvider
import ru.kozirfm.persistent_storage.di.PersistentStorageDependenciesProvider
import ru.kozirfm.persistent_storage.di.PersistentStorageFeature

class App : Application() {

    private val coreComponent by lazy { CoreFeature.getComponent(this) }
    private val persistentStorageComponent by lazy { PersistentStorageFeature.getComponent() }
    private val networkComponent by lazy { NetworkFeature.getComponent() }
    private val navigationComponent by lazy { NavigationFeature.getComponent() }
    private val imageLoaderComponent by lazy { ImageLoaderFeature.getComponent() }
    private val firebaseComponent by lazy { FirebaseFeature.getComponent() }

    override fun onCreate() {
        super.onCreate()
//        FirebaseMessaging.getInstance().subscribeToTopic("all")
        BaseDependenciesProvider.set(navigationComponent)
        PersistentStorageDependenciesProvider.set(coreComponent)
        FirebaseDependenciesProvider.set(persistentStorageComponent)
        NewsDependenciesProvider.set(networkComponent, navigationComponent, imageLoaderComponent)
        LoginDependenciesProvider.set(networkComponent, navigationComponent, firebaseComponent)
    }

}
