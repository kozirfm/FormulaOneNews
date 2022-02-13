package ru.kozirfm.navigation_api

import com.redmadrobot.extensions.lifecycle.EventQueue

interface EventsDispatcher {

    val events: EventQueue

    fun navigateTo(
        screen: String,
        arguments: List<String>? = null,
        isRoot: Boolean = false
    ) {
        events.offerEvent(
            NavigationEvent.ToUri(
                screen = screen,
                arguments = arguments,
                isRoot = isRoot
            )
        )
    }

}