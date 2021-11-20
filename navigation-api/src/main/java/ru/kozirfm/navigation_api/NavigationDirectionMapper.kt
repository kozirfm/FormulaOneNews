package ru.kozirfm.navigation_api

import androidx.navigation.NavDirections
import ru.kozirfm.utils.mapper.BaseMapper

class NavigationDirectionMapper : BaseMapper<NavDirections, NavigationDirection> {
    override fun map(response: NavDirections): NavigationDirection {
        return NavigationDirectionImpl(response.actionId, response.arguments)
    }
}