package ru.kozirfm.core.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.kozirfm.core_api.di.CoreDependencies
import ru.kozirfm.core_api.di.annotation.AppScope

@AppScope
@Component(modules = [CoreModule::class])
interface CoreComponent : CoreDependencies {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder
        fun build(): CoreComponent
    }
}