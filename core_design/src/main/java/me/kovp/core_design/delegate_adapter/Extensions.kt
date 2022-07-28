package me.kovp.core_design.delegate_adapter

import androidx.compose.runtime.Composable
import kotlin.reflect.KClass

inline fun <reified T : ItemViewState> lazyColumnAdapterDelegate(
    crossinline action: @Composable T.() -> Unit
) = object : ViewStateAdapterDelegate {

    override val clazz: KClass<out ItemViewState>
        get() = T::class

    override fun isDelegateValid(itemToBind: ItemViewState): Boolean {
        return itemToBind::class == clazz
    }

    var item: T? = null
        private set

    @Composable
    override fun BindViewState(itemToBind: ItemViewState) {
        if (isDelegateValid(itemToBind)) {
            item = itemToBind as T
            item?.let { action(it) }
        }
    }
}