package ru.kozirfm.calendar.datasource

import ru.kozirfm.network_api.utils.ResponseState

interface CalendarRemoteDataSource {
    suspend fun getCalendar(): ResponseState
}