package ru.kozirfm.network.di

import dagger.Component
import ru.kozirfm.core.di.annotation.AppScope
import ru.kozirfm.network_api.di.NetworkDependencies

@AppScope
@Component(modules = [NetworkModule::class])
interface NetworkComponent: NetworkDependencies