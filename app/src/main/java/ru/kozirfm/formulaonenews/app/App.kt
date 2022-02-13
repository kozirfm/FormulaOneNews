package ru.kozirfm.formulaonenews.app

import android.app.Application
import androidx.compose.material.ExperimentalMaterialApi
import ru.kozirfm.formulaonenews.di.ApplicationModule
import ru.kozirfm.formulaonenews.di.DaggerApplicationComponent

@ExperimentalMaterialApi
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initDagger()
//        FirebaseMessaging.getInstance().subscribeToTopic("all")
    }

    private fun initDagger() {
        DaggerApplicationComponent.builder().applicationModule(
            ApplicationModule(this)
        ).build().apply {
            getCoreFeature().getApi()
        }
    }

}
