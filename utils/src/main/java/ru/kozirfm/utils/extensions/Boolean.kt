package ru.kozirfm.utils.extensions

fun Boolean?.safeBoolean(): Boolean {
    return this == true
}