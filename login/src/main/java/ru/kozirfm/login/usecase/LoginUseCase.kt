package ru.kozirfm.login.usecase

import ru.kozirfm.login.entity.Login
import ru.kozirfm.network_api.utils.ResponseState

interface LoginUseCase {
    suspend fun signIn(login: Login): ResponseState
    suspend fun signUp(login: Login): ResponseState
}