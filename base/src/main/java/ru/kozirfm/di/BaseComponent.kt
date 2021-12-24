package ru.kozirfm.di

import dagger.Component
import ru.kozirfm.base.BaseFragment
import ru.kozirfm.core_api.di.annotation.AppScope

@AppScope
@Component (dependencies = [BaseDependencies::class])
interface BaseComponent: BaseFeatureApi {
    fun inject(fragment: BaseFragment)
}