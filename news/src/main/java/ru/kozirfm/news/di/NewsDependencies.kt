package ru.kozirfm.news.di

import ru.kozirfm.image_loader_api.di.ImageLoaderFeatureApi
import ru.kozirfm.navigation_api.di.NavigationFeatureApi
import ru.kozirfm.network_api.di.NetworkFeatureApi

interface NewsDependencies: NetworkFeatureApi, NavigationFeatureApi, ImageLoaderFeatureApi