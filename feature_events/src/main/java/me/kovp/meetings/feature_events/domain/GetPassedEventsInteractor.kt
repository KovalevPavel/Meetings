package me.kovp.meetings.feature_events.domain

class GetPassedEventsInteractor(
    private val repo: EventsRepository
) {
    suspend operator fun invoke(): List<EventVo> {
        return repo.getPassedEvents()
    }
}