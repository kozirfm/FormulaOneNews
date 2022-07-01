package ru.kozirfm.calendar.di

import dagger.Component
import ru.kozirfm.calendar.ui.CalendarFragment
import ru.kozirfm.core.annotation.PerFeature

@PerFeature
@Component(
    modules = [CalendarModule::class],
    dependencies = [CalendarDependencies::class]
)
interface CalendarComponent : CalendarFeatureApi {
    fun inject(calendarFragment: CalendarFragment)
}