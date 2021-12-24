package ru.kozirfm.login.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.viewModels
import com.redmadrobot.extensions.lifecycle.observe
import ru.kozirfm.base.BaseFragment
import ru.kozirfm.login.di.LoginFeature
import ru.kozirfm.viewmodel.ViewModelFactory
import javax.inject.Inject

class LoginFragment : BaseFragment(useComposeView = true) {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by viewModels<LoginViewModel> { viewModelFactory }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        LoginFeature.loginComponent?.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe(viewModel.events, this::handleEvent)
        (view as ComposeView).setContent { LoginScreen(viewModel) }
    }
}