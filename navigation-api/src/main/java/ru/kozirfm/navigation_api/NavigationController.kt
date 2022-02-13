package ru.kozirfm.navigation_api

import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import com.google.android.material.bottomnavigation.BottomNavigationView

interface NavigationController {

    fun setRootNavController(activityNavController: NavController)

    fun handleNavigationEvent(
        fragment: Fragment,
        event: NavigationEvent
    )

    fun setupBottomNavigationBar(
        fragment: Fragment,
        bottomNavigationView: BottomNavigationView?
    )

    fun setupToolbar(
        fragment: Fragment,
        toolbar: Toolbar?
    )

}