package ru.kozirfm.core.base

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.compose.material.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.redmadrobot.extensions.lifecycle.observe
import ru.kozirfm.core.di.CoreFeature
import javax.inject.Inject

class SplashFragment : BaseFragment(useComposeView = true) {

    private val viewModel by viewModels<SplashViewModel> { viewModelFactory }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onAttach(context: Context) {
        super.onAttach(context)
        CoreFeature.getComponent().inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe(viewModel.events, this::handleEvent)
        (view as ComposeView).setContent {
            Text(text = "Formula 1", color = Color.Black)
        }
    }
}