package ru.kozirfm.calendar.usecase

import ru.kozirfm.network_api.utils.ResponseState

interface CalendarUseCase {
    suspend fun getCalendar(): ResponseState
}