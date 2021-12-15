package ru.kozirfm.utils.extensions

fun emptyString() = ""

fun String?.orEmpty(): String {
    return this ?: emptyString()
}