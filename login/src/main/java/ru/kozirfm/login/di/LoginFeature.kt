package ru.kozirfm.login.di

import ru.kozirfm.core.annotation.AppScope
import ru.kozirfm.core.base.ScreenFeature
import javax.inject.Inject

@AppScope
class LoginFeature @Inject constructor(dependencies: LoginDependencies) : ScreenFeature<LoginFeatureApi> {

    private val _api: LoginFeatureApi by lazy {
        DaggerLoginComponent.builder()
            .loginDependencies(dependencies)
            .build()
            .also { loginComponent = it }
    }

    override fun getApi() = _api
    override fun getScreenName(): String = LOGIN_SCREEN

    companion object {
        const val LOGIN_SCREEN = "LoginScreen"
        var loginComponent: LoginComponent? = null
    }
}