package ru.kozirfm.formulaonenews.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.kozirfm.calendar.di.CalendarDependencies
import ru.kozirfm.calendar.di.CalendarFeature
import ru.kozirfm.calendar.di.CalendarFeatureApi
import ru.kozirfm.core.annotation.AppScope
import ru.kozirfm.core.base.ScreenFeature
import ru.kozirfm.core.di.BaseDependencies
import ru.kozirfm.core.di.CoreDependencies
import ru.kozirfm.core.di.CoreFeature
import ru.kozirfm.core.di.CoreFeatureApi
import ru.kozirfm.di.NavigationDependencies
import ru.kozirfm.di.NavigationFeature
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
import ru.kozirfm.news_detail.di.NewsDetailDependencies
import ru.kozirfm.news_detail.di.NewsDetailFeature
import ru.kozirfm.news_detail.di.NewsDetailFeatureApi
import ru.kozirfm.persistent_storage.di.PersistentStorageDependencies
import ru.kozirfm.persistent_storage.di.PersistentStorageFeature
import ru.kozirfm.persistent_storage_api.di.PersistentStorageFeatureApi
import javax.inject.Provider

@Module(includes = [FeaturesModule::class])
class ApplicationModule(private val applicationContext: Context) {

    @Provides
    @AppScope
    fun provideBaseDependencies(
        screens: Provider<Set<@JvmSuppressWildcards ScreenFeature<*>>>,
    ): BaseDependencies {
        return object : BaseDependencies {
            override fun getContext(): Context = applicationContext
            override fun getScreens(): Set<ScreenFeature<*>> = screens.get()
        }
    }

    @Provides
    @AppScope
    fun provideCoreFeatureApi(feature: CoreFeature): CoreFeatureApi {
        return feature.getApi()
    }

    @Provides
    @AppScope
    fun provideCoreFeatureDependencies(
        navigationFeatureApi: NavigationFeatureApi
    ): CoreDependencies {
        return DaggerCoreExportComponent.builder()
            .navigationFeatureApi(navigationFeatureApi)
            .build()
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
    fun providesNavigationDependencies(
        baseDependencies: BaseDependencies
    ): NavigationDependencies {
        return DaggerNavigationExportComponent.builder()
            .baseDependencies(baseDependencies)
            .build()
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
        baseDependencies: BaseDependencies
    ): PersistentStorageDependencies {
        return DaggerPersistentStorageExportComponent.builder()
            .baseDependencies(baseDependencies)
            .build()
    }

    @Provides
    @AppScope
    fun providesNewsFeatureApi(feature: NewsFeature): NewsFeatureApi {
        return feature.getApi()
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

    @Provides
    @AppScope
    fun provideNewsDetailFeatureApi(feature: NewsDetailFeature): NewsDetailFeatureApi {
        return feature.getApi()
    }

    @Provides
    @AppScope
    fun provideNewsDetailDependencies(
        networkFeatureApi: NetworkFeatureApi,
        navigationFeatureApi: NavigationFeatureApi,
        imageLoaderFeatureApi: ImageLoaderFeatureApi
    ): NewsDetailDependencies {
        return DaggerNewsDetailExportComponent.builder()
            .networkFeatureApi(networkFeatureApi)
            .navigationFeatureApi(navigationFeatureApi)
            .imageLoaderFeatureApi(imageLoaderFeatureApi)
            .build()
    }

    @Provides
    @AppScope
    fun provideCalendarFeatureApi(feature: CalendarFeature): CalendarFeatureApi {
        return feature.getApi()
    }

    @Provides
    @AppScope
    fun provideCalendarDependencies(
        networkFeatureApi: NetworkFeatureApi,
        navigationFeatureApi: NavigationFeatureApi,
        imageLoaderFeatureApi: ImageLoaderFeatureApi
    ): CalendarDependencies {
        return DaggerCalendarExportComponent.builder()
            .networkFeatureApi(networkFeatureApi)
            .navigationFeatureApi(navigationFeatureApi)
            .imageLoaderFeatureApi(imageLoaderFeatureApi)
            .build()
    }
}