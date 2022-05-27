package me.kovp.feature_events

import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import me.kovp.core_design.delegate_adapter.Decorator
import me.kovp.core_design.delegate_adapter.ItemViewState
import me.kovp.core_design.load
import me.kovp.core_design.setOnClick
import me.kovp.feature_events.databinding.ItemEventBinding

fun eventCardDelegate(onEventClick: (String) -> Unit) =
    adapterDelegateViewBinding<EventCardAdapterData, ItemViewState, ItemEventBinding>(
        viewBinding = { layoutInflater, parent ->
            ItemEventBinding.inflate(layoutInflater, parent, false)
        }
    ) {
        binding.root.setOnClick { onEventClick(item.id) }

        bind {
            binding.apply {
                ivArchivedEventCover.load(item.coverUrl)
                tvArchivedEventTitle.text = item.title
                tvArchivedEventDate.text = item.date
            }
        }
    }

data class EventCardAdapterData(
    override val id: String,
    override val decorator: Decorator?,
    val coverUrl: String,
    val title: String,
    val date: String
) : ItemViewState()