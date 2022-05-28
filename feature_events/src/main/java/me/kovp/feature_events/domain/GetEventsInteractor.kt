package me.kovp.feature_events.domain

class GetEventsInteractor(
    private val repo: EventsRepository
) {
    suspend operator fun invoke() = repo.getAllEvents()
}