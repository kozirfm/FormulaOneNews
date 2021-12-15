package ru.kozirfm.core_api.di

import android.content.Context
import ru.kozirfm.core_api.preferences.PersistentStorage

/**
 * Интерфейс для предоставления зависимостей из модулей app и core
 */
interface CoreDependencies {
    fun getContext(): Context
    fun getPersistentStorage(): PersistentStorage
}