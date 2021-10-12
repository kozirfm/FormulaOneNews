package ru.kozirfm.core.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.redmadrobot.extensions.lifecycle.Event
import ru.kozirfm.core.di.CoreFeature
import ru.kozirfm.navigation_api.Navigation
import ru.kozirfm.navigation_api.NavigationEvent
import javax.inject.Inject

abstract class BaseFragment(layout: Int) : Fragment(layout) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoreFeature.getComponent().inject(this)
    }

    @Inject
    lateinit var navigation: Navigation

    fun handleEvent(event: Event) {
        when (event) {
            is NavigationEvent -> {
                navigation.handleNavigationEvent(
                    requireActivity(),
                    this,
                    event
                )
            }
        }
    }
}