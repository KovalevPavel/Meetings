package me.kovp.core_design.delegate_adapter

import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil

object DefaultDifferConfig {

    private val callback by lazy {
        object : DiffUtil.ItemCallback<ItemViewState>() {
            override fun areItemsTheSame(oldItem: ItemViewState, newItem: ItemViewState): Boolean {
                return oldItem.isItemTheSame(newItem)
            }

            override fun areContentsTheSame(
                oldItem: ItemViewState,
                newItem: ItemViewState
            ): Boolean {
                return oldItem.isContentTheSame(newItem)
            }

        }
    }

    val config by lazy {
        AsyncDifferConfig
            .Builder(callback)
            .build()
    }
}