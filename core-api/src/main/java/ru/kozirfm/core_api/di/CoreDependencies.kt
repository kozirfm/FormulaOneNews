package ru.kozirfm.core_api.di

import android.content.Context

/**
 * Интерфейс для предоставления зависимостей из модулей app и core
 */
interface CoreDependencies {
    fun getContext(): Context
}