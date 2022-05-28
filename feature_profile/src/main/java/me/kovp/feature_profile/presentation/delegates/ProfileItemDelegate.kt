package me.kovp.feature_profile.presentation.delegates

import androidx.annotation.DrawableRes
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import me.kovp.core_design.delegate_adapter.Decorator
import me.kovp.core_design.delegate_adapter.ItemViewState
import me.kovp.core_design.setOnClick
import me.kovp.feature_profile.databinding.ItemProfileItemBinding
import java.util.UUID

fun profileItemDelegate(onItemClick: (ProfileItemAdapterData) -> Unit) =
    adapterDelegateViewBinding<ProfileItemAdapterData, ItemViewState, ItemProfileItemBinding>(
        viewBinding = { layoutInflater, parent ->
            ItemProfileItemBinding.inflate(layoutInflater, parent, false)
        }
    ) {
        binding.root.setOnClick { onItemClick(item) }

        bind {
            binding.ivProfileItemIcon.setImageResource(item.icon)
            binding.tvProfileItemTitle.text = item.title
        }
    }

data class ProfileItemAdapterData(
    override val id: String = UUID.randomUUID().toString(),
    override val decorator: Decorator? = null,
    @DrawableRes
    val icon: Int,
    val title: String,
) : ItemViewState()