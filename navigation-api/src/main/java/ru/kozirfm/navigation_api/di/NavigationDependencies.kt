package ru.kozirfm.navigation_api.di

import ru.kozirfm.navigation_api.Navigation

interface NavigationDependencies {
    fun getNavigation(): Navigation
}