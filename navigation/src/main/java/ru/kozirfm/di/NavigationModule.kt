package ru.kozirfm.di

import dagger.Module
import dagger.Provides
import ru.kozirfm.core_api.di.annotation.AppScope
import ru.kozirfm.navigation.NavigateRootDirectionImpl
import ru.kozirfm.navigation.NavigationControllerImpl
import ru.kozirfm.navigation_api.NavigateRootDirection
import ru.kozirfm.navigation_api.NavigationController

@Module
class NavigationModule {

    @AppScope
    @Provides
    fun provideNavigation(): NavigationController {
        return NavigationControllerImpl()
    }

    @AppScope
    @Provides
    fun provideRootDirections(): NavigateRootDirection {
        return NavigateRootDirectionImpl()
    }

}