package ru.kozirfm.network.di

object NetworkFeature {
    fun getComponent(): NetworkComponent {
        return DaggerNetworkComponent.create()
    }
}