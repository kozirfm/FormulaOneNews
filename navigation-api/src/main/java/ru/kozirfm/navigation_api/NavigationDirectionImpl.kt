package ru.kozirfm.navigation_api

import android.os.Bundle

class NavigationDirectionImpl(
    private val actionId: Int,
    private val arguments: Bundle
) : NavigationDirection {

    override fun getActionId(): Int {
        return actionId
    }

    override fun getArguments(): Bundle {
        return arguments
    }

}