package ru.kozirfm.core.di

import android.content.Context
import ru.kozirfm.core.base.ScreenFeature


interface BaseDependencies {
    fun getContext(): Context
    fun getScreens(): Set<ScreenFeature>
}