package ru.kozirfm.navigation_api

import android.app.Activity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView

interface NavigationController {

    fun handleNavigationEvent(
        activity: Activity,
        fragment: Fragment,
        event: NavigationEvent
    )

    fun setupBottomNavigationBar(
        activity: Activity,
        fragment: Fragment,
        toolbar: Toolbar,
        childFragmentManager: FragmentManager,
        bottomNavigationView: BottomNavigationView
    )

}