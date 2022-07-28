package me.kovp.feature_auth.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import me.kovp.core_design.components.recycle_compose.RecycleCompose
import me.kovp.core_design.components.text_input_field.editTextAdapterDelegate
import me.kovp.feature_auth.di.authModule
import org.koin.androidx.compose.getViewModel
import org.koin.core.context.loadKoinModules

@Composable
fun GetCodeCompose(
    onNextClick: () -> Unit
) {
    loadKoinModules(authModule())
    val state = rememberLazyListState()

    val vm = getViewModel<AuthViewModel>()

    val items by vm.items.observeAsState(emptyList())

    Column {
        RecycleCompose(
            items = items,
            state = state,
            editTextAdapterDelegate(vm::onTextChange)
        )
    }
}
