package ru.kozirfm.core.base

interface ScreenFeature<T> {
    fun getApi(): T
    fun getScreenName(): String
}