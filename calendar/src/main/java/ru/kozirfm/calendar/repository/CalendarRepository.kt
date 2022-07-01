package ru.kozirfm.calendar.repository

import ru.kozirfm.network_api.utils.ResponseState

interface CalendarRepository {
    suspend fun getCalendar(): ResponseState
}