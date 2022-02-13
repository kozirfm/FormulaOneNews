package ru.kozirfm.core.base

interface ScreenFeature {
    fun getApi(): ScreenCreator
    fun getScreenName(): String
}