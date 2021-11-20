package ru.kozirfm.formulaonenews.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import ru.kozirfm.core.di.CoreDependencies
import ru.kozirfm.core.di.annotation.AppScope

@AppScope
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent: CoreDependencies {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): ApplicationComponent
    }

}