package ru.kozirfm.utils.mapper

interface BaseMapper<In, Out> {
    fun map(response: In): Out
}