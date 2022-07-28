package me.kovp.meetings.feature_events.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import me.kovp.core_design.MessageDialogVs
import me.kovp.core_design.delegate_adapter.ItemViewStates
import me.kovp.core_design.tab_layout.TabItemAdapterData
import me.kovp.meetings.core.SingleLiveEvent
import me.kovp.meetings.core.launch
import timber.log.Timber

interface EventsViewModel {
    val tabs: LiveData<List<TabItemAdapterData>>
    val items: LiveData<List<ItemViewStates>>
    val isLoadingEvent: LiveData<Boolean>
    val messageDialogEvent: LiveData<MessageDialogVs>

    fun onTabSelected(tabItem: TabItemAdapterData)
    fun onMessageDialogClick(dialog: MessageDialogVs)
    fun doOnRefresh()
}

class EventsViewModelImpl(
) : ViewModel(), EventsViewModel {
    override val tabs = MutableLiveData<List<TabItemAdapterData>>()
    override val items = MutableLiveData<List<ItemViewStates>>()
    override val isLoadingEvent = SingleLiveEvent<Boolean>()
    override val messageDialogEvent = SingleLiveEvent<MessageDialogVs>()


    init {
        fetchTabs()
    }

    override fun onTabSelected(tabItem: TabItemAdapterData) {
        launch(
            body = {
            },
            error = { Timber.d(it) }
        )
    }

    override fun onMessageDialogClick(dialog: MessageDialogVs) {
        Timber.d("dialog title: ${dialog.title}")
    }

    override fun doOnRefresh() {

    }

    private fun fetchTabs() {
        launch(
            body = {
                isLoadingEvent.value = true
                tabs.value = listOf(
                    TabItemAdapterData(
                        id = FUTURE_EVENTS_TAB_ID,
                        tabTitle = "Предстоящие"
                    ),
                    TabItemAdapterData(
                        id = PASSED_EVENTS_TAB_ID,
                        tabTitle = "Прошедшие"
                    )
                )
            },
            error = Timber::e,
            final = { isLoadingEvent.value = false }
        )

    }

    companion object {
        private const val FUTURE_EVENTS_TAB_ID = "FUTURE_EVENTS_TAB_ID"
        private const val PASSED_EVENTS_TAB_ID = "PASSED_EVENTS_TAB_ID"
    }
}