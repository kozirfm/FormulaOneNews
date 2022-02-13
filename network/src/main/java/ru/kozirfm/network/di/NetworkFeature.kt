package ru.kozirfm.network.di

import ru.kozirfm.network_api.di.NetworkFeatureApi
import javax.inject.Inject

class NetworkFeature @Inject constructor() {

    private val _api: NetworkFeatureApi by lazy {
        DaggerNetworkComponent
            .create()
            .also {
                networkComponent = it
            }
    }

    fun getApi() = _api

    internal companion object {
        var networkComponent: NetworkComponent? = null
    }
}