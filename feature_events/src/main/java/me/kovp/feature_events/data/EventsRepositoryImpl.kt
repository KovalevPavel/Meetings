package me.kovp.feature_events.data

import me.kovp.feature_events.domain.EventVo
import me.kovp.feature_events.domain.EventsRepository

class EventsRepositoryImpl: EventsRepository {
    override suspend fun getAllEvents(): List<EventVo> {
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
            ),
            EventVo(
                title = "ДР Юры",
                cover = "https://upload.wikimedia.org/wikipedia/commons/9/9e/Domestic_cat.jpg",
                date = 12388888
            )
        )
    }
}