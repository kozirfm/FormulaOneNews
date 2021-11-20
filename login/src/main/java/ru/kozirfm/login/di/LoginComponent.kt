package ru.kozirfm.login.di

import dagger.Component
import ru.kozirfm.core.di.annotation.PerFeature
import ru.kozirfm.login.ui.LoginFragment
import ru.kozirfm.navigation_api.di.NavigationDependencies
import ru.kozirfm.network_api.di.NetworkDependencies

@PerFeature
@Component(
    modules = [LoginModule::class],
    dependencies = [NetworkDependencies::class, NavigationDependencies::class]
)
interface LoginComponent {
    fun inject(loginFragment: LoginFragment)
}