package ru.kozirfm.formulaonenews.di

import dagger.Component
import ru.kozirfm.core_api.di.annotation.AppScope

@AppScope
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent