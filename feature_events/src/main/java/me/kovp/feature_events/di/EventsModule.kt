package me.kovp.feature_events.di

import me.kovp.feature_events.data.EventsRepositoryImpl
import me.kovp.feature_events.domain.EventsRepository
import me.kovp.feature_events.domain.GetEventsInteractor
import me.kovp.feature_events.presentation.EventsScreenMapper
import me.kovp.feature_events.presentation.EventsViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module

fun Module.eventsModule() {
    single<EventsRepository> { EventsRepositoryImpl() }
    single { GetEventsInteractor(get()) }
    single { EventsScreenMapper() }

    viewModel {
        EventsViewModelImpl(
            getEvents = get(),
            mapper = get()
        )
    }
}