package me.kovp.feature_events.presentation

import me.kovp.core_design.delegate_adapter.ItemViewState
import me.kovp.core_design.delegate_adapter.SpaceDecorator
import me.kovp.feature_events.domain.EventVo
import java.util.UUID

class EventsScreenMapper {
    fun map(items: List<EventVo>) = mutableListOf<ItemViewState>().apply {
        items.map(::mapEventItem).let(::addAll)
    }

    private fun mapEventItem(item: EventVo) = EventCardAdapterData(
        id = UUID.randomUUID().toString(),
        decorator = SpaceDecorator(),
        coverUrl = item.cover,
        title = item.title,
        date = item.date.toString()
    )
}