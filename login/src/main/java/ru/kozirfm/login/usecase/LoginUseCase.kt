package ru.kozirfm.login.usecase

import ru.kozirfm.login.entity.Login
import ru.kozirfm.network_api.utils.ResponseState

interface LoginUseCase {

    suspend fun getUserToken(login: Login): ResponseState
}