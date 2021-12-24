package ru.kozirfm.di

import dagger.Component
import ru.kozirfm.core_api.di.annotation.AppScope
import ru.kozirfm.navigation_api.di.NavigationFeatureApi

@AppScope
@Component(modules = [NavigationModule::class])
interface NavigationComponent : NavigationFeatureApi