package ru.kozirfm.navigation_api

import com.redmadrobot.extensions.lifecycle.Event

sealed class NavigationEvent : Event {

    data class ToUri(
        val screen: String,
        val arguments: List<String>?,
        val isRoot: Boolean
    ) : NavigationEvent()

}