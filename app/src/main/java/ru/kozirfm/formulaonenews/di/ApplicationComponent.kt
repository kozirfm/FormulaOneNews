package ru.kozirfm.formulaonenews.di

import androidx.compose.material.ExperimentalMaterialApi
import dagger.Component
import ru.kozirfm.core.annotation.AppScope
import ru.kozirfm.core.di.CoreFeature

@AppScope
@ExperimentalMaterialApi
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun getCoreFeature(): CoreFeature
}