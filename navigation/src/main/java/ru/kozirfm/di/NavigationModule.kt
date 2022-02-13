package ru.kozirfm.di

import dagger.Binds
import dagger.Module
import ru.kozirfm.core.annotation.AppScope
import ru.kozirfm.navigation.NavigationControllerImpl
import ru.kozirfm.navigation.NavigatorImpl
import ru.kozirfm.navigation_api.NavigationController
import ru.kozirfm.navigation_api.Navigator

@Module
interface NavigationModule {

    @AppScope
    @Binds
    fun provideNavigation(impl: NavigationControllerImpl): NavigationController

    @AppScope
    @Binds
    fun provideRootDirections(impl: NavigatorImpl): Navigator

}