package me.kovp.core_design

import androidx.annotation.DimenRes
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import me.kovp.core_design.databinding.ItemSpaceBinding
import me.kovp.core_design.delegate_adapter.ItemViewState

fun spaceItemDelegate() =
    adapterDelegateViewBinding<SpaceItemAdapterData, ItemViewState, ItemSpaceBinding>(
        viewBinding = { layoutInflater, parent ->
            ItemSpaceBinding.inflate(layoutInflater, parent, false)
        }
    ) {
        bind {
            val layoutParams = binding.root.layoutParams
            layoutParams.height = context.resources.getDimensionPixelSize(item.height)

            binding.root.layoutParams = layoutParams
        }
    }

data class SpaceItemAdapterData(
    @DimenRes
    val height: Int
) : ItemViewState()