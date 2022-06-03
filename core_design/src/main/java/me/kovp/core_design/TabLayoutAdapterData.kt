package me.kovp.core_design

import androidx.annotation.DrawableRes
import androidx.appcompat.view.menu.MenuView.ItemView
import com.google.android.material.tabs.TabItem
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import me.kovp.core_design.databinding.ItemTabLayoutBinding
import me.kovp.core_design.delegate_adapter.ItemViewState

fun tabLayoutItemAdapterDelegate(onTabSelected: (TabItemAdapterData) -> Unit) =
    adapterDelegateViewBinding<TabLayoutAdapterData, ItemViewState, ItemTabLayoutBinding>(
        viewBinding = { layoutInflater, parent ->
            ItemTabLayoutBinding.inflate(layoutInflater, parent, false)
        }
    ) {
    }

data class TabLayoutAdapterData(
    override val id: String,
    val tabs: List<TabItemAdapterData>
) : ItemViewState()

data class TabItemAdapterData(
    override val id: String,
    val tabTitle: String = "",
    @DrawableRes
    val tabIcon: Int = 0
) : ItemViewState()