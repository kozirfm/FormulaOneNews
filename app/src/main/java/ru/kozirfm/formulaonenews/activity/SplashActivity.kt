package ru.kozirfm.formulaonenews.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.whenResumed
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.kozirfm.core.R
import ru.kozirfm.core.base.BaseActivity
import java.util.concurrent.TimeUnit

@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    override fun onResume() {
        super.onResume()
        val intent = Intent(this, MainActivity::class.java)
        lifecycleScope.launch {
            whenResumed {
                delay(SPLASH_TIMEOUT)
                startActivity(intent)
            }
        }
    }

    override fun onPause() {
        super.onPause()
        finish()
    }

    private companion object {
        val SPLASH_TIMEOUT = TimeUnit.SECONDS.toMillis(1)

    }

}