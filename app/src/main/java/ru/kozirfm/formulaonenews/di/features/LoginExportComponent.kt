package ru.kozirfm.formulaonenews.di.features

import dagger.Component
import ru.kozirfm.firebase_api.di.FirebaseFeatureApi
import ru.kozirfm.login.di.LoginDependencies
import ru.kozirfm.navigation_api.di.NavigationFeatureApi
import ru.kozirfm.network_api.di.NetworkFeatureApi

@Component(
    dependencies = [
        NetworkFeatureApi::class,
        NavigationFeatureApi::class,
        FirebaseFeatureApi::class
    ]
)
interface LoginExportComponent : LoginDependencies