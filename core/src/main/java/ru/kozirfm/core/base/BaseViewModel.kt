package ru.kozirfm.core.base

import android.util.Log
import androidx.lifecycle.ViewModel
import com.redmadrobot.extensions.lifecycle.EventQueue
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import ru.kozirfm.navigation_api.EventsDispatcher

abstract class BaseViewModel : ViewModel(), EventsDispatcher {

    abstract val screenName: String

    override val events = EventQueue()

    val coroutineContext by lazy { CoroutineName(screenName) + exceptionHandler }

    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        Log.w("TAG", throwable)
    }

    companion object {
        const val MIN_LOADING_TIMEOUT = 1500L
    }

}