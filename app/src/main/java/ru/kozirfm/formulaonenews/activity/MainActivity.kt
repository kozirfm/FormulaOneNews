package ru.kozirfm.formulaonenews.activity

import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.findNavController
import ru.kozirfm.core.base.BaseActivity
import ru.kozirfm.formulaonenews.R

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        val navController = findNavController(R.id.main_activity_container)
        navigationController.setRootNavController(navController)
    }

}