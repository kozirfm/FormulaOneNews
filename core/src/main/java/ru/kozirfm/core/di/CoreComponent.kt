package ru.kozirfm.core.di

import dagger.Component
import ru.kozirfm.core.base.BaseFragment
import ru.kozirfm.core.base.SplashFragment
import ru.kozirfm.core.di.annotation.PerFeature
import ru.kozirfm.navigation_api.di.NavigationDependencies

@PerFeature
@Component(modules = [CoreModule::class], dependencies = [NavigationDependencies::class])
interface CoreComponent {
    fun inject(fragment: BaseFragment)
    fun inject(fragment: SplashFragment)
}