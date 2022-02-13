package ru.kozirfm.core.base

import android.util.Log
import androidx.lifecycle.ViewModel
import com.redmadrobot.extensions.lifecycle.EventQueue
import kotlinx.coroutines.CoroutineExceptionHandler
import ru.kozirfm.navigation_api.EventsDispatcher

abstract class BaseViewModel : ViewModel(), EventsDispatcher {

    val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        Log.w(coroutineContext.toString(), throwable)
    }

    override val events = EventQueue()

    companion object {
        const val MIN_LOADING_TIMEOUT = 1500L
    }

}