package me.kovp.core_design.components.recycle_compose

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import me.kovp.core_design.delegate_adapter.ItemViewState
import me.kovp.core_design.delegate_adapter.ViewStateAdapterDelegate

@Composable
fun RecycleCompose(
    items: List<ItemViewState>,
    state: LazyListState,
    modifier: Modifier = Modifier,
    vararg adapters: ViewStateAdapterDelegate,
) {
    LazyColumn(
        state = state,
        modifier = modifier,
    ) {
        itemsIndexed(items) { index, item ->
            adapters.firstOrNull { it.isDelegateValid(item) }
                ?.BindViewState(item)
                ?: throw RuntimeException("Missing delegate for position $index")
        }
    }
}
