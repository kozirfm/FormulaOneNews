package ru.kozirfm.formulaonenews.di.features

import dagger.Component
import ru.kozirfm.core.di.CoreDependencies
import ru.kozirfm.navigation_api.di.NavigationFeatureApi

@Component(dependencies = [NavigationFeatureApi::class])
interface CoreExportComponent : CoreDependencies