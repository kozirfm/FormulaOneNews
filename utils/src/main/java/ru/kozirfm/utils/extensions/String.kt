package ru.kozirfm.utils.extensions

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

fun emptyString() = ""

inline fun <reified T> String.decodeFromString(): T {
    return Json.decodeFromString(this)
}