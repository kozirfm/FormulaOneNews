package ru.kozirfm.login.di

import dagger.Component
import ru.kozirfm.core_api.di.annotation.PerFeature
import ru.kozirfm.login.ui.LoginFragment

@PerFeature
@Component(
    modules = [LoginModule::class],
    dependencies = [LoginDependencies::class]
)
interface LoginComponent: LoginFeatureApi {
    fun inject(loginFragment: LoginFragment)
}