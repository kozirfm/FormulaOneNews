package ru.kozirfm.formulaonenews.di.features

import dagger.Component
import ru.kozirfm.image_loader_api.di.ImageLoaderFeatureApi
import ru.kozirfm.navigation_api.di.NavigationFeatureApi
import ru.kozirfm.network_api.di.NetworkFeatureApi
import ru.kozirfm.news.di.NewsDependencies

@Component(
    dependencies = [
        NetworkFeatureApi::class,
        NavigationFeatureApi::class,
        ImageLoaderFeatureApi::class
    ]
)
interface NewsExportComponent : NewsDependencies