package ru.kozirfm.formulaonenews.app

import android.app.Application
import androidx.compose.material.ExperimentalMaterialApi
import ru.kozirfm.formulaonenews.di.ApplicationComponent
import ru.kozirfm.formulaonenews.di.ApplicationModule
import ru.kozirfm.formulaonenews.di.DaggerApplicationComponent

@ExperimentalMaterialApi
class App : Application() {

    private val applicationComponent: ApplicationComponent =
        DaggerApplicationComponent.builder().applicationModule(
            ApplicationModule(this)
        ).build()

    override fun onCreate() {
        super.onCreate()
        applicationComponent.apply {
            getBaseFeature().getApi()
            getNewsFeature().getApi()
            getLoginFeature().getApi()
        }
//        FirebaseMessaging.getInstance().subscribeToTopic("all")
    }

}
