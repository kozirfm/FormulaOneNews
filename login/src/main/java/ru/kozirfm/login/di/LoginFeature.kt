package ru.kozirfm.login.di

import ru.kozirfm.core_api.di.annotation.AppScope
import javax.inject.Inject

@AppScope
class LoginFeature @Inject constructor(dependencies: LoginDependencies) {

    private val _api: LoginFeatureApi by lazy {
        DaggerLoginComponent.builder()
            .loginDependencies(dependencies)
            .build()
            .also { loginComponent = it }
    }

    fun getApi() = _api

    internal companion object {
        var loginComponent: LoginComponent? = null
    }
}