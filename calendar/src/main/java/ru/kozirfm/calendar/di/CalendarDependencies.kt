package ru.kozirfm.calendar.di

import ru.kozirfm.image_loader_api.di.ImageLoaderFeatureApi
import ru.kozirfm.navigation_api.di.NavigationFeatureApi
import ru.kozirfm.network_api.di.NetworkFeatureApi

interface CalendarDependencies : NetworkFeatureApi, NavigationFeatureApi, ImageLoaderFeatureApi