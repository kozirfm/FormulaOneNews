package ru.kozirfm.di

import dagger.Module
import dagger.Provides
import ru.kozirfm.core.di.annotation.AppScope
import ru.kozirfm.navigation.NavigationControllerImpl
import ru.kozirfm.navigation.RootDirectionsImpl
import ru.kozirfm.navigation_api.NavigationController
import ru.kozirfm.navigation_api.RootDirections

@Module
class NavigationModule {

    @AppScope
    @Provides
    fun provideNavigation(): NavigationController {
        return NavigationControllerImpl()
    }

    @AppScope
    @Provides
    fun provideRootDirections(): RootDirections {
        return RootDirectionsImpl()
    }

}