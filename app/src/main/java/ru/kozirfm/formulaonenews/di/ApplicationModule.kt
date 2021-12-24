package ru.kozirfm.formulaonenews.di

import android.content.Context
import androidx.compose.material.ExperimentalMaterialApi
import dagger.Module
import dagger.Provides
import ru.kozirfm.core.di.CoreDependencies
import ru.kozirfm.core.di.CoreFeature
import ru.kozirfm.core_api.di.CoreFeatureApi
import ru.kozirfm.core_api.di.annotation.AppScope
import ru.kozirfm.di.*
import ru.kozirfm.firebase.di.FirebaseDependencies
import ru.kozirfm.firebase.di.FirebaseFeature
import ru.kozirfm.firebase_api.di.FirebaseFeatureApi
import ru.kozirfm.formulaonenews.di.features.*
import ru.kozirfm.image_loader.di.ImageLoaderDependencies
import ru.kozirfm.image_loader.di.ImageLoaderFeature
import ru.kozirfm.image_loader_api.di.ImageLoaderFeatureApi
import ru.kozirfm.login.di.LoginDependencies
import ru.kozirfm.login.di.LoginFeature
import ru.kozirfm.login.di.LoginFeatureApi
import ru.kozirfm.navigation_api.di.NavigationFeatureApi
import ru.kozirfm.network.di.NetworkDependencies
import ru.kozirfm.network.di.NetworkFeature
import ru.kozirfm.network_api.di.NetworkFeatureApi
import ru.kozirfm.news.di.NewsDependencies
import ru.kozirfm.news.di.NewsFeature
import ru.kozirfm.news.di.NewsFeatureApi
import ru.kozirfm.persistent_storage.di.PersistentStorageDependencies
import ru.kozirfm.persistent_storage.di.PersistentStorageFeature
import ru.kozirfm.persistent_storage_api.di.PersistentStorageFeatureApi

@Module
@ExperimentalMaterialApi
class ApplicationModule(private val applicationContext: Context) {

    @Provides
    @AppScope
    fun provideContext(): Context = applicationContext

    @Provides
    @AppScope
    fun provideBaseFeatureApi(feature: BaseFeature): BaseFeatureApi {
        return feature.getApi()
    }

    @Provides
    @AppScope
    fun provideBaseFeatureDependencies(navigationFeatureApi: NavigationFeatureApi): BaseDependencies {
        return DaggerBaseExportComponent.builder()
            .navigationFeatureApi(navigationFeatureApi)
            .build()
    }

    @Provides
    @AppScope
    fun provideCoreFeatureApi(feature: CoreFeature): CoreFeatureApi {
        return feature.getApi()
    }

    @Provides
    @AppScope
    fun provideCoreFeatureDependencies(): CoreDependencies {
        return DaggerCoreExportComponent.create()
    }

    @Provides
    @AppScope
    fun provideNetworkFeatureApi(feature: NetworkFeature): NetworkFeatureApi {
        return feature.getApi()
    }

    @Provides
    @AppScope
    fun providesNetworkDependencies(): NetworkDependencies {
        return DaggerNetworkExportComponent.create()
    }

    @Provides
    @AppScope
    fun provideNavigationFeatureApi(feature: NavigationFeature): NavigationFeatureApi {
        return feature.getApi()
    }

    @Provides
    @AppScope
    fun providesNavigationDependencies(): NavigationDependencies {
        return DaggerNavigationExportComponent.create()
    }

    @Provides
    @AppScope
    fun provideImageLoaderFeatureApi(feature: ImageLoaderFeature): ImageLoaderFeatureApi {
        return feature.getApi()
    }

    @Provides
    @AppScope
    fun providesImageLoaderDependencies(): ImageLoaderDependencies {
        return DaggerImageLoaderExportComponent.create()
    }

    @Provides
    @AppScope
    fun providesNewsFeatureApi(feature: NewsFeature): NewsFeatureApi {
        return feature.getApi()
    }

    @Provides
    @AppScope
    fun provideFirebaseFeatureApi(feature: FirebaseFeature): FirebaseFeatureApi {
        return feature.getApi()
    }

    @Provides
    @AppScope
    fun provideFirebaseDependencies(
        persistentStorageFeatureApi: PersistentStorageFeatureApi
    ): FirebaseDependencies {
        return DaggerFirebaseExportComponent.builder()
            .persistentStorageFeatureApi(persistentStorageFeatureApi)
            .build()
    }

    @Provides
    @AppScope
    fun providePersistentStorageFeature(feature: PersistentStorageFeature): PersistentStorageFeatureApi {
        return feature.getApi()
    }

    @Provides
    @AppScope
    fun providePersistentStorageDependencies(
        coreFeatureApi: CoreFeatureApi
    ): PersistentStorageDependencies {
        return DaggerPersistentStorageExportComponent.builder()
            .coreFeatureApi(coreFeatureApi)
            .build()
    }

    @Provides
    @AppScope
    fun provideNewsDependencies(
        networkFeatureApi: NetworkFeatureApi,
        navigationFeatureApi: NavigationFeatureApi,
        imageLoaderFeatureApi: ImageLoaderFeatureApi
    ): NewsDependencies {
        return DaggerNewsExportComponent.builder()
            .networkFeatureApi(networkFeatureApi)
            .navigationFeatureApi(navigationFeatureApi)
            .imageLoaderFeatureApi(imageLoaderFeatureApi)
            .build()
    }

    @Provides
    @AppScope
    fun provideLoginFeatureApi(feature: LoginFeature): LoginFeatureApi {
        return feature.getApi()
    }

    @Provides
    @AppScope
    fun provideLoginDependencies(
        networkFeatureApi: NetworkFeatureApi,
        navigationFeatureApi: NavigationFeatureApi,
        firebaseFeatureApi: FirebaseFeatureApi
    ): LoginDependencies {
        return DaggerLoginExportComponent.builder()
            .networkFeatureApi(networkFeatureApi)
            .navigationFeatureApi(navigationFeatureApi)
            .firebaseFeatureApi(firebaseFeatureApi)
            .build()
    }
}