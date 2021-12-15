package ru.kozirfm.core_api.preferences

interface PersistentStorage {
    fun save(key: String, value: String)
    fun load(key: String): String
}