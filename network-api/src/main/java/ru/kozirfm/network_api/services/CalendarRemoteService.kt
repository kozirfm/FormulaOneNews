package ru.kozirfm.network_api.services

import kotlinx.coroutines.Deferred

interface CalendarRemoteService {
    fun getCalendarAsync(): Deferred<String>
}