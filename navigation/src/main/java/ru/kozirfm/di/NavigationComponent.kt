package ru.kozirfm.di

import dagger.Component
import ru.kozirfm.core.annotation.AppScope
import ru.kozirfm.navigation_api.di.NavigationFeatureApi

@AppScope
@Component(
    modules = [NavigationModule::class],
    dependencies = [NavigationDependencies::class]
)
interface NavigationComponent : NavigationFeatureApi