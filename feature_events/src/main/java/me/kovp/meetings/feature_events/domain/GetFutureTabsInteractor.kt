package me.kovp.meetings.feature_events.domain

class GetFutureTabsInteractor(
    private val repo: EventsRepository
) {
    suspend operator fun invoke(): List<EventVo> {
        return repo.getFutureEvents()
    }
}