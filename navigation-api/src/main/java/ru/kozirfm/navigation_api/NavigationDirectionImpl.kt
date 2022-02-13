package ru.kozirfm.navigation_api

import android.os.Bundle

class NavigationDirectionImpl(
    private val actionId: Int,
    private val arguments: Bundle
) : NavigationDirection {
    override fun getActionIds(): Int = actionId
    override fun getArguments(): Bundle = arguments
}