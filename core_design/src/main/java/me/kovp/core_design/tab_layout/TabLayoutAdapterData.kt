package me.kovp.core_design.tab_layout

import me.kovp.core_design.delegate_adapter.ItemViewStates

data class TabLayoutAdapterData(
    override val id: String,
    val tabs: List<TabItemAdapterData>
) : ItemViewStates()