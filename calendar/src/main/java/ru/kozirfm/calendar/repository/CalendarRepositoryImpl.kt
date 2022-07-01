package ru.kozirfm.calendar.repository

import ru.kozirfm.calendar.datasource.CalendarRemoteDataSource
import ru.kozirfm.network_api.utils.ResponseState
import javax.inject.Inject

class CalendarRepositoryImpl @Inject constructor(
    private val calendarRemoteDataSource: CalendarRemoteDataSource
) : CalendarRepository {
    override suspend fun getCalendar(): ResponseState {
        return calendarRemoteDataSource.getCalendar()
    }
}