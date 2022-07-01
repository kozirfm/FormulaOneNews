package ru.kozirfm.calendar.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import ru.kozirfm.calendar.di.CalendarFeature
import ru.kozirfm.core.base.BaseFragment
import ru.kozirfm.image_loader_api.ImageLoader
import javax.inject.Inject

class CalendarFragment : BaseFragment(useComposeView = true) {

    private val viewModel by viewModels<CalendarViewModel> { viewModelFactory }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @set:Inject
    var imageLoader: ImageLoader? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        CalendarFeature.calendarComponent?.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (view as ComposeView).apply {
            setContent {
                CalendarScreen(viewModel = viewModel, imageLoader = imageLoader)
            }
        }
    }
}