package ru.kozirfm.core.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.kozirfm.core.di.CoreFeature
import ru.kozirfm.navigation_api.NavigationController
import javax.inject.Inject

abstract class BaseActivity : AppCompatActivity() {

    @Inject
    lateinit var navigationController: NavigationController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoreFeature.coreComponent?.inject(this)
    }
}