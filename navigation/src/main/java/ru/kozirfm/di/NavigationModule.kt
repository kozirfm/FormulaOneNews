package ru.kozirfm.di

import dagger.Module
import dagger.Provides
import ru.kozirfm.core.di.annotation.AppScope
import ru.kozirfm.navigation.NavigationImpl
import ru.kozirfm.navigation_api.Navigation

@Module
class NavigationModule {

    @AppScope
    @Provides
    fun provideNavigation(): Navigation {
        return NavigationImpl()
    }

}