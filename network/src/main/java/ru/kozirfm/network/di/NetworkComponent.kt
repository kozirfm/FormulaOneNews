package ru.kozirfm.network.di

import dagger.Component
import ru.kozirfm.core_api.di.annotation.AppScope
import ru.kozirfm.network_api.di.NetworkFeatureApi

@AppScope
@Component(modules = [NetworkModule::class])
interface NetworkComponent: NetworkFeatureApi