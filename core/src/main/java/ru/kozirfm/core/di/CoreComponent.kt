package ru.kozirfm.core.di

import dagger.Component
import ru.kozirfm.core.annotation.AppScope
import ru.kozirfm.core.base.BaseActivity
import ru.kozirfm.core.base.BaseFragment

@AppScope
@Component (dependencies = [CoreDependencies::class])
interface CoreComponent: CoreFeatureApi {
    fun inject(activity: BaseActivity)
    fun inject(fragment: BaseFragment)
}