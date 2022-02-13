package ru.kozirfm.utils.json

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

val json = Json {
    isLenient = true
    ignoreUnknownKeys = true
}

inline fun <reified T> String.decodeFromString(): T {
    return json.decodeFromString(this)
}

inline fun <reified T> T.encodeToString(): String {
    return json.encodeToString(this)
}