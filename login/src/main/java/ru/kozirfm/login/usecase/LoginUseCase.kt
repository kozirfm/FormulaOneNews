package ru.kozirfm.login.usecase

import ru.kozirfm.login.entity.User
import ru.kozirfm.network_api.utils.ResponseState

interface LoginUseCase {
    suspend fun signIn(user: User): ResponseState
    suspend fun signUp(user: User): ResponseState
}