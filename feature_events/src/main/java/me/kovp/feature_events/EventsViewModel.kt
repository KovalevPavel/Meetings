package me.kovp.feature_events

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import me.kovp.core_design.delegate_adapter.ItemViewState
import me.kovp.core_design.delegate_adapter.SpaceDecorator

interface EventsViewModel {
    val items: LiveData<List<ItemViewState>>
}

class EventsViewModelImpl: ViewModel(), EventsViewModel {
    override val items = MutableLiveData<List<ItemViewState>>()

    init {
        items.value = listOf(
            EventCardAdapterData(
                id = "",
                decorator = SpaceDecorator(),
                coverUrl = "https://upload.wikimedia.org/wikipedia/commons/9/9e/Domestic_cat.jpg",
                title = "Мероприятие 1",
                date = "13 фервраля"
            ),
            EventCardAdapterData(
                id = "",
                decorator = SpaceDecorator(),
                coverUrl = "https://upload.wikimedia.org/wikipedia/commons/9/9e/Domestic_cat.jpg",
                title = "Мероприятие 2",
                date = "13 фервраля"
            ),
            EventCardAdapterData(
                id = "",
                decorator = SpaceDecorator(),
                coverUrl = "https://upload.wikimedia.org/wikipedia/commons/9/9e/Domestic_cat.jpg",
                title = "Мероприятие 3",
                date = "13 фервраля"
            )
        )
    }
}