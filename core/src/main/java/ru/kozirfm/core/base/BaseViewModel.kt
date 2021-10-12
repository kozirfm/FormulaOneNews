package ru.kozirfm.core.base

import androidx.lifecycle.ViewModel
import com.redmadrobot.extensions.lifecycle.EventQueue
import ru.kozirfm.navigation_api.EventsDispatcher

abstract class BaseViewModel : ViewModel(), EventsDispatcher {

    override val events = EventQueue()

}