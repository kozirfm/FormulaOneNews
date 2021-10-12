package ru.kozirfm.core.di

import android.app.Application

/**
 * Интерфейс для предоставления зависимостей из модулей app и core
 */
interface CoreDependencies {
    fun getApplication(): Application
}