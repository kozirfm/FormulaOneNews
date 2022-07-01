package ru.kozirfm.formulaonenews.di

import dagger.Component
import ru.kozirfm.core.annotation.AppScope
import ru.kozirfm.core.di.CoreFeature

@AppScope
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun getCoreFeature(): CoreFeature
}