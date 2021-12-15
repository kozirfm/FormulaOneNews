package ru.kozirfm.di

import dagger.Component
import ru.kozirfm.di.annotation.AppScope
import ru.kozirfm.navigation_api.di.NavigationDependencies

@AppScope
@Component(modules = [NavigationModule::class])
interface NavigationComponent : NavigationDependencies