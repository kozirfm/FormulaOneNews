package ru.kozirfm.navigation

import android.app.Activity
import androidx.annotation.IdRes
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.redmadrobot.extensions.lifecycle.observe
import ru.kozirfm.navigation_api.NavigationController
import ru.kozirfm.navigation_api.NavigationEvent
import ru.kozirfm.navigation_api.setupWithNavController
import ru.kozirfm.utils.extensions.visible

class NavigationControllerImpl : NavigationController {

    override fun setupBottomNavigationBar(
        fragment: Fragment,
        bottomNavigationView: BottomNavigationView,
        childFragmentManager: FragmentManager,
        activity: Activity,
        toolbar: Toolbar
    ) {
        val navController = bottomNavigationView.setupWithNavController(
            fragmentManager = childFragmentManager,
            containerId = R.id.main_fragment_container,
            intent = activity.intent,
            navGraphIds = listOf(
                R.navigation.menu_news_nav_graph,
                R.navigation.menu_championship_nav_graph,
                R.navigation.menu_calendar_nav_graph
            )
        )
        fragment.observe(navController) { controller ->
            toolbar.setupWithNavController(controller)
            controller.addOnDestinationChangedListener { _, destination, _ ->
                bottomNavigationView.visible = when (destination.id) {
                    R.id.newsFragment -> true
                    else -> true
                }
            }
        }
    }

    override fun handleNavigationEvent(
        activity: Activity,
        fragment: Fragment,
        event: NavigationEvent
    ) {
        when (event) {
            is NavigationEvent.ToDirection -> {
                getNavController(
                    event.rootGraph,
                    R.id.main_activity_container,
                    fragment,
                    activity
                ).navigate(event.direction)
            }
            is NavigationEvent.ToRes -> {
                getNavController(
                    event.rootGraph,
                    R.id.main_activity_container,
                    fragment,
                    activity
                ).navigate(
                    event.resId,
                    event.args
                )
            }
            is NavigationEvent.Up -> fragment.findNavController().navigateUp()
            is NavigationEvent.Back -> if (!fragment.findNavController().popBackStack()) activity.finish()
            is NavigationEvent.BackTo -> fragment.findNavController().popBackStack(
                event.destinationId,
                event.inclusive
            )
        }
    }

    private fun getNavController(
        rootGraph: Boolean = false,
        @IdRes layoutRes: Int,
        fragment: Fragment,
        activity: Activity
    ): NavController {
        return if (rootGraph) {
            activity.findNavController(layoutRes)
        } else {
            fragment.findNavController()
        }
    }

}