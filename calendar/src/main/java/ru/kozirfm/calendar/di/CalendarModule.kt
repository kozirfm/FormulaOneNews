package ru.kozirfm.calendar.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.kozirfm.calendar.datasource.CalendarRemoteDataSource
import ru.kozirfm.calendar.datasource.CalendarRemoteDataSourceImpl
import ru.kozirfm.calendar.repository.CalendarRepository
import ru.kozirfm.calendar.repository.CalendarRepositoryImpl
import ru.kozirfm.calendar.ui.CalendarViewModel
import ru.kozirfm.calendar.usecase.CalendarUseCase
import ru.kozirfm.calendar.usecase.CalendarUseCaseImpl
import ru.kozirfm.core.annotation.PerFeature
import ru.kozirfm.core.di.ViewModelModule
import ru.kozirfm.core.viewmodel.ViewModelKey

@Module(includes = [ViewModelModule::class])
interface CalendarModule {

    @Binds
    @PerFeature
    fun bindCalendarRemoteDataSource(remoteDataSource: CalendarRemoteDataSourceImpl): CalendarRemoteDataSource

    @Binds
    @PerFeature
    fun bindCalendarRepository(repository: CalendarRepositoryImpl): CalendarRepository

    @Binds
    @PerFeature
    fun bindCalendarUseCase(useCase: CalendarUseCaseImpl): CalendarUseCase

    @Binds
    @IntoMap
    @ViewModelKey(CalendarViewModel::class)
    fun bindCalendarViewModel(viewModel: CalendarViewModel): ViewModel
}