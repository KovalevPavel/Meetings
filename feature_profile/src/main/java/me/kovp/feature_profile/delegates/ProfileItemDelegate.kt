package me.kovp.feature_profile.delegates

import androidx.annotation.DrawableRes
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import me.kovp.core_design.delegate_adapter.ItemViewState
import me.kovp.core_design.setOnClick
import me.kovp.feature_profile.databinding.ItemProfileItemBinding

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
    @DrawableRes
    val icon: Int,
    val title: String
) : ItemViewState()