package ru.kozirfm.navigation

import androidx.navigation.NavDirections
import ru.kozirfm.navigation_api.RootDirections
import ru.kozirfm.navigation_graph.RootNavGraphDirections

class RootDirectionsImpl : RootDirections {

    override fun toMainFragment(): NavDirections {
        return RootNavGraphDirections.toMainFragment()
    }

}