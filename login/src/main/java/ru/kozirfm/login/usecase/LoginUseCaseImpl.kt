package ru.kozirfm.login.usecase

import kotlinx.coroutines.withTimeoutOrNull
import ru.kozirfm.firebase_api.FirebaseHelper
import ru.kozirfm.login.entity.User
import ru.kozirfm.login.repository.LoginRepository
import ru.kozirfm.network_api.utils.ResponseState
import javax.inject.Inject

class LoginUseCaseImpl
@Inject
constructor(
    private val repository: LoginRepository,
    private val firebaseHelper: FirebaseHelper
) : LoginUseCase {

    override suspend fun signIn(user: User): ResponseState? {
        return withTimeoutOrNull(REQUEST_TIMEOUT) {
            val token = firebaseHelper.getToken()
            repository.signIn(user = user.copy(firebaseToken = token))
        }

    }

    override suspend fun signUp(user: User): ResponseState? {
        return withTimeoutOrNull(REQUEST_TIMEOUT) {
            val token = firebaseHelper.getToken()
            repository.signUp(user = user.copy(firebaseToken = token))
        }
    }

    private companion object {
        const val REQUEST_TIMEOUT = 10000L
    }
}