package ru.kozirfm.calendar.datasource

import ru.kozirfm.calendar_api.entity.OutCalendar
import ru.kozirfm.calendar_api.mapper.ToInCalendarMapper
import ru.kozirfm.network_api.services.CalendarRemoteService
import ru.kozirfm.network_api.utils.ResponseHandler
import ru.kozirfm.network_api.utils.ResponseState
import ru.kozirfm.utils.json.decodeFromString
import javax.inject.Inject

class CalendarRemoteDataSourceImpl @Inject constructor(
    private val api: CalendarRemoteService,
    private val responseHandler: ResponseHandler
) : CalendarRemoteDataSource {

    override suspend fun getCalendar(): ResponseState {
        return responseHandler.handleResponse(api.getCalendarAsync()) { result ->
            result.decodeFromString<List<OutCalendar>>().map {
                ToInCalendarMapper.map(it)
            }
        }
    }


}