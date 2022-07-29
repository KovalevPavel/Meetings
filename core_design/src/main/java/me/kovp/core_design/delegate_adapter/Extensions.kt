package me.kovp.core_design.delegate_adapter

import androidx.compose.runtime.Composable

inline fun <reified T : ItemViewState> lazyColumnAdapterDelegate(
    crossinline action: @Composable T.() -> Unit
) = object : ViewStateAdapterDelegate {

    override fun isDelegateValid(itemToBind: ItemViewState): Boolean {
        return itemToBind::class == T::class
    }

    @Composable
    override fun BindViewState(itemToBind: ItemViewState) {
        (itemToBind as? T)
            ?.let { action(it) }
            ?: throw RuntimeException("Can't convert $itemToBind to ${T::class}")
    }
}