package ru.kozirfm.calendar.usecase

import ru.kozirfm.calendar.repository.CalendarRepository
import ru.kozirfm.network_api.utils.ResponseState
import javax.inject.Inject

class CalendarUseCaseImpl @Inject constructor(
    private val calendarRepository: CalendarRepository
) : CalendarUseCase {
    override suspend fun getCalendar(): ResponseState {
        return calendarRepository.getCalendar()
    }
}