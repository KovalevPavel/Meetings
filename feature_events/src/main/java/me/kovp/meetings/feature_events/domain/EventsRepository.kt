package me.kovp.meetings.feature_events.domain

interface EventsRepository {
    suspend fun getFutureEvents(): List<EventVo>
    suspend fun getPassedEvents(): List<EventVo>
}