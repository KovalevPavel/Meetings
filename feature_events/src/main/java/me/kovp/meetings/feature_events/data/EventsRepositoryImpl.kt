package me.kovp.meetings.feature_events.data

import me.kovp.meetings.feature_events.domain.EventVo
import me.kovp.meetings.feature_events.domain.EventsRepository

class EventsRepositoryImpl : EventsRepository {
    override suspend fun getFutureEvents(): List<EventVo> {
        return listOf(
            EventVo(
                title = "ДР Юры",
                cover = "https://upload.wikimedia.org/wikipedia/commons/9/9e/Domestic_cat.jpg",
                date = 12388888
            )
        )
    }

    override suspend fun getPassedEvents(): List<EventVo> {
        return listOf(
            EventVo(
                title = "Новый год",
                cover = "https://upload.wikimedia.org/wikipedia/commons/9/9e/Domestic_cat.jpg",
                date = 12345678
            ),
            EventVo(
                title = "ДР Бони",
                cover = "https://upload.wikimedia.org/wikipedia/commons/9/9e/Domestic_cat.jpg",
                date = 12357789
            )
        )
    }
}