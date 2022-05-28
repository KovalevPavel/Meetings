package me.kovp.feature_events.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import me.kovp.core_design.delegate_adapter.ItemViewState
import me.kovp.feature_events.domain.GetEventsInteractor

interface EventsViewModel {
    val items: LiveData<List<ItemViewState>>
}

class EventsViewModelImpl(
    private val getEvents: GetEventsInteractor,
    private val mapper: EventsScreenMapper,
) : ViewModel(), EventsViewModel {
    override val items = MutableLiveData<List<ItemViewState>>()

    init {
        fetchAllEvents()
    }

    private fun fetchAllEvents() {
        viewModelScope.launch {
            mapper.map(
                items = getEvents()
            )
                .let(items::postValue)
        }
    }
}