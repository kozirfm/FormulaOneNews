package ru.kozirfm.login.usecase

import ru.kozirfm.login.repository.LoginRepository
import ru.kozirfm.login.entity.Login
import ru.kozirfm.network_api.utils.ResponseState
import javax.inject.Inject

class LoginUseCaseImpl
@Inject
constructor(private val repository: LoginRepository) : LoginUseCase {

    override suspend fun getUserToken(login: Login): ResponseState {
        return repository.getUserToken(login)
    }
}