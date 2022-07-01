package ru.kozirfm.calendar.di

import ru.kozirfm.core.annotation.AppScope
import ru.kozirfm.core.base.ScreenFeature
import ru.kozirfm.core.screens.Screen
import javax.inject.Inject

@AppScope
class CalendarFeature @Inject constructor(dependencies: CalendarDependencies) : ScreenFeature<CalendarFeatureApi> {

    private val _api: CalendarFeatureApi by lazy {
        DaggerCalendarComponent
            .builder()
            .calendarDependencies(dependencies)
            .build()
            .also { calendarComponent = it }
    }

    override fun getApi() = _api
    override fun getScreenName(): String = CALENDAR_SCREEN

    companion object {
        val CALENDAR_SCREEN = Screen.CALENDAR.name
        var calendarComponent: CalendarComponent? = null
    }
}