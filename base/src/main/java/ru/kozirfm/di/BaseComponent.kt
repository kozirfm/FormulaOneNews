package ru.kozirfm.di

import dagger.Component
import ru.kozirfm.base.BaseFragment
import ru.kozirfm.core_api.di.annotation.AppScope
import ru.kozirfm.navigation_api.di.NavigationDependencies

@AppScope
@Component (dependencies = [NavigationDependencies::class])
interface BaseComponent {
    fun inject(fragment: BaseFragment)
}