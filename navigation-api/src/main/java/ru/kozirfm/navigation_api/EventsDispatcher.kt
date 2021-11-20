package ru.kozirfm.navigation_api

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.navigation.NavDirections
import com.redmadrobot.extensions.lifecycle.EventQueue

interface EventsDispatcher {

    val events: EventQueue

    fun navigateTo(direction: NavigationDirection, rootGraph: Boolean = false) {
        events.offerEvent(NavigationEvent.ToDirection(direction as NavDirections, rootGraph))
    }

    fun navigateTo(@IdRes resId: Int, args: Bundle? = null, rootGraph: Boolean = false) {
        events.offerEvent(NavigationEvent.ToRes(resId, args, rootGraph))
    }

    fun navigateUp() {
        events.offerEvent(NavigationEvent.Up)
    }

    fun navigateBack() {
        events.offerEvent(NavigationEvent.Back)
    }

    fun navigateBackTo(destinationId: Int, inclusive: Boolean) {
        events.offerEvent(NavigationEvent.BackTo(destinationId, inclusive))
    }

}