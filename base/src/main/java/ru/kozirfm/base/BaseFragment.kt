package ru.kozirfm.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.redmadrobot.extensions.lifecycle.Event
import ru.kozirfm.di.BaseFeature
import ru.kozirfm.navigation_api.NavigationController
import ru.kozirfm.navigation_api.NavigationEvent
import javax.inject.Inject

abstract class BaseFragment(
    private val layout: Int? = null,
    private val useComposeView: Boolean = false
) : Fragment() {

    @Inject
    lateinit var navigationController: NavigationController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        BaseFeature.getComponent().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return if (useComposeView) {
            ComposeView(requireContext())
        } else {
            layout?.let { inflater.inflate(layout, container, false) }
        }
    }

    fun handleEvent(event: Event) {
        when (event) {
            is NavigationEvent -> {
                navigationController.handleNavigationEvent(
                    requireActivity(),
                    this,
                    event
                )
            }
        }
    }
}