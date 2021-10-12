package ru.kozirfm.di

object NavigationFeature {

    fun getComponent(): NavigationComponent {
        return DaggerNavigationComponent
            .builder()
            .build()
    }
}