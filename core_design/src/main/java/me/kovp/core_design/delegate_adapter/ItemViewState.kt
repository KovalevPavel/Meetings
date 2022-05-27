package me.kovp.core_design.delegate_adapter

import java.util.UUID

abstract class ItemViewState {
    open val id: String = UUID.randomUUID().toString()
    open val decorator: Decorator? = null

    open fun isItemTheSame(item: ItemViewState): Boolean = this.id == item.id
    open fun isContentTheSame(item: ItemViewState): Boolean = this == item
}