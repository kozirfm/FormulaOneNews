package ru.kozirfm.formulaonenews.di.features

import dagger.Component
import ru.kozirfm.core.di.BaseDependencies
import ru.kozirfm.di.NavigationDependencies

@Component(dependencies = [BaseDependencies::class])
interface NavigationExportComponent : NavigationDependencies