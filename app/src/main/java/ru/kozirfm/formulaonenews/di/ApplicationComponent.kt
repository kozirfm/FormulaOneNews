package ru.kozirfm.formulaonenews.di

import dagger.Component
import ru.kozirfm.di.annotation.AppScope

@AppScope
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent