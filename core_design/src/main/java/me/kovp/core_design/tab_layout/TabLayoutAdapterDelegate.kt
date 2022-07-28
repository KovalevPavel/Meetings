package me.kovp.core_design.tab_layout

import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import me.kovp.core_design.ItemViewStateListener
import me.kovp.core_design.databinding.ItemTabLayoutBinding
import me.kovp.core_design.delegate_adapter.ItemViewStates

fun tabLayoutItemAdapterDelegate(tabListener: ItemViewStateListener<TabItemAdapterData>) =
    adapterDelegateViewBinding<TabLayoutAdapterData, ItemViewStates, ItemTabLayoutBinding>(
        viewBinding = { layoutInflater, parent ->
            ItemTabLayoutBinding.inflate(layoutInflater, parent, false)
        }
    ) {
        binding.root.listener = tabListener

        bind {
            binding.root.applyViewState(item)
        }


    }
