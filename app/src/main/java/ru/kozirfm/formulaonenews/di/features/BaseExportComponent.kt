package ru.kozirfm.formulaonenews.di.features

import dagger.Component
import ru.kozirfm.di.BaseDependencies
import ru.kozirfm.navigation_api.di.NavigationFeatureApi

@Component(dependencies = [NavigationFeatureApi::class])
interface BaseExportComponent : BaseDependencies