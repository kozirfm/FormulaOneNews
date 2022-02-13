package ru.kozirfm.news_detail.di

import ru.kozirfm.image_loader_api.di.ImageLoaderFeatureApi
import ru.kozirfm.navigation_api.di.NavigationFeatureApi
import ru.kozirfm.network_api.di.NetworkFeatureApi

interface NewsDetailDependencies : NetworkFeatureApi, NavigationFeatureApi, ImageLoaderFeatureApi