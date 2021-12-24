package ru.kozirfm.login.di

import ru.kozirfm.firebase_api.di.FirebaseFeatureApi
import ru.kozirfm.navigation_api.di.NavigationFeatureApi
import ru.kozirfm.network_api.di.NetworkFeatureApi

interface LoginDependencies: NetworkFeatureApi, NavigationFeatureApi, FirebaseFeatureApi