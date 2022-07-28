package me.kovp.core_design.tab_layout

import androidx.annotation.DrawableRes
import me.kovp.core_design.delegate_adapter.ItemViewStates

data class TabItemAdapterData(
    override val id: String,
    val tabTitle: String = "",
    @DrawableRes
    val tabIcon: Int = 0
) : ItemViewStates()