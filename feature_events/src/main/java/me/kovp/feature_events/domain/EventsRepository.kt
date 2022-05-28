package me.kovp.feature_events.domain

interface EventsRepository {
    suspend fun getAllEvents(): List<EventVo>
}