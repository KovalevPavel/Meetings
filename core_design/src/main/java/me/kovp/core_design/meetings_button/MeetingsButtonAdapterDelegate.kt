package me.kovp.core_design.meetings_button

import androidx.annotation.StyleRes
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import me.kovp.core_design.R
import me.kovp.core_design.databinding.ItemMeetingsButtonBinding
import me.kovp.core_design.delegate_adapter.ItemViewState
import java.util.UUID

fun meetingsButtonAdapterDelegate(onButtonClick: (MeetingsButtonAdapterData) -> Unit) =
    adapterDelegateViewBinding<MeetingsButtonAdapterData, ItemViewState, ItemMeetingsButtonBinding>(
        viewBinding = { layoutInflater, parent ->
            ItemMeetingsButtonBinding.inflate(layoutInflater, parent, false)
        }
    ) {
        bind {
            binding.root.viewState = item
            binding.root.listener = onButtonClick
        }
    }

data class MeetingsButtonAdapterData(
    override val id: String = UUID.randomUUID().toString(),
    @StyleRes
    val style: Int = R.style.MeetingsButtonPrimaryActive,
    val state: ButtonState = ButtonState()
) : ItemViewState() {
    data class ButtonState(
        val title: String = "",
        val enabled: Boolean = true
    )
}