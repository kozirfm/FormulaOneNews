package ru.kozirfm.login.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import ru.kozirfm.login.entity.Login
import ru.kozirfm.utils.extensions.emptyString

@Composable
fun LoginScreen(viewModel: LoginViewModel) {
    var username by remember { mutableStateOf(emptyString()) }
    var password by remember { mutableStateOf(emptyString()) }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        OutlinedTextField(
            modifier = Modifier.padding(bottom = 8.dp),
            singleLine = true,
            value = username,
            onValueChange = { username = it },
            placeholder = { Text(text = "Логин") }
        )
        OutlinedTextField(
            singleLine = true,
            value = password,
            visualTransformation = PasswordVisualTransformation(mask = '\u2055'),
            onValueChange = { password = it },
            placeholder = { Text(text = "Пароль") }
        )
        Button(
            modifier = Modifier.padding(top = 8.dp),
            onClick = {
                viewModel.signIn(
                    Login(
                        username = username,
                        password = password
                    )
                )
            }
        ) { Text(text = "Войти") }
        Button(
            modifier = Modifier.padding(vertical = 8.dp),
            onClick = {
                viewModel.signUp(
                    Login(
                        username = username,
                        password = password
                    )
                )
            }
        ) { Text(text = "Зарегистрироваться") }
    }
}