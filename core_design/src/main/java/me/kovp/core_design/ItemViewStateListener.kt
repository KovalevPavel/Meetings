package me.kovp.core_design

import me.kovp.core_design.delegate_adapter.ItemViewStates

class ItemViewStateListener<T : ItemViewStates>(private val action: (T) -> Unit) {
    operator fun invoke(item: T) = action(item)
}