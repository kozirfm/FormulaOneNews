package ru.kozirfm.login.di

object LoginFeature {
    fun getComponent(): LoginComponent {
        return DaggerLoginComponent
            .builder()
            .networkDependencies(LoginDependenciesProvider.networkDependencies)
            .navigationDependencies(LoginDependenciesProvider.navigationDependencies)
            .firebaseDependencies(LoginDependenciesProvider.firebaseDependencies)
            .build()
    }
}