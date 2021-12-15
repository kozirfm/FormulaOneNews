package ru.kozirfm.persistent_storage_api

interface PersistentStorage {
    fun save(key: String, value: String)
    fun load(key: String): String
}