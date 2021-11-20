package ru.kozirfm.navigation

import ru.kozirfm.navigation_api.NavigateRootDirection
import ru.kozirfm.navigation_api.NavigationDirection
import ru.kozirfm.navigation_api.NavigationDirectionMapper


class NavigateRootDirectionImpl : NavigateRootDirection {

    override fun toMainFragment(): NavigationDirection {
        return NavigationDirectionMapper().map(RootNavGraphDirections.toMainFragment())
    }

}