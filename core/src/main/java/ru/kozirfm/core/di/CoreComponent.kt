package ru.kozirfm.core.di

import dagger.Component
import ru.kozirfm.core.base.BaseFragment
import ru.kozirfm.core.di.annotation.PerFeature
import ru.kozirfm.navigation_api.di.NavigationDependencies

@PerFeature
@Component(dependencies = [NavigationDependencies::class])
interface CoreComponent {
    fun inject(fragment: BaseFragment)
}