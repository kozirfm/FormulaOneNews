package ru.kozirfm.login.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.redmadrobot.extensions.lifecycle.observe
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.kozirfm.core.base.BaseFragment
import ru.kozirfm.core.viewmodel.ViewModelFactory
import ru.kozirfm.login.di.LoginFeature
import ru.kozirfm.login.entity.Login
import ru.kozirfm.utils.extensions.emptyString
import javax.inject.Inject

class LoginFragment : BaseFragment(useComposeView = true) {

    private val viewModel by viewModels<LoginViewModel> { viewModelFactory }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onAttach(context: Context) {
        super.onAttach(context)
        LoginFeature.getComponent().inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe(viewModel.events, this::handleEvent)
        (view as ComposeView).setContent {
            LoginScreen()
        }
    }

    private fun getToken() {
        lifecycleScope.launch {
            viewModel.getData(
                Login(
                    "username",
                    "password",
                    "token"
                )
            )
                .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
                .collect {
                    Log.w(LoginFragment::class.java.name, it.token)
                }
        }
    }

}

@Preview
@Composable
fun LoginScreen() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(value = emptyString(), onValueChange = {
        }, placeholder = {
            Text(text = "Login")
        })
        TextField(value = emptyString(), onValueChange = {

        }, placeholder = {
            Text(text = "Password")
        })
        Button(modifier = Modifier.padding(top = 8.dp), onClick = {

        }) {
            Text(text = "Войти")
        }
        Button(modifier = Modifier.padding(vertical = 8.dp), onClick = {

        }) {
            Text(text = "Зарегистрироваться")
        }

    }
}