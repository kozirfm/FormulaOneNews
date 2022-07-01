package ru.kozirfm.formulaonenews.di.features

import dagger.Component
import ru.kozirfm.calendar.di.CalendarDependencies
import ru.kozirfm.image_loader_api.di.ImageLoaderFeatureApi
import ru.kozirfm.navigation_api.di.NavigationFeatureApi
import ru.kozirfm.network_api.di.NetworkFeatureApi

@Component(
    dependencies = [
        NetworkFeatureApi::class,
        NavigationFeatureApi::class,
        ImageLoaderFeatureApi::class
    ]
)
interface CalendarExportComponent : CalendarDependencies