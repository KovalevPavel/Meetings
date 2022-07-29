package me.kovp.feature_auth.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import me.kovp.core_design.components.button.buttonAdapterDelegate
import me.kovp.core_design.components.recycle_compose.RecycleCompose
import me.kovp.core_design.components.text_field.textAdapterDelegate
import me.kovp.core_design.components.text_input_field.editTextAdapterDelegate
import me.kovp.feature_auth.di.authModule
import org.koin.androidx.compose.getViewModel
import org.koin.core.context.loadKoinModules

@Composable
fun GetCodeCompose(
    onReceiveCode: (String) -> Unit
) {
    loadKoinModules(authModule())
    val state = rememberLazyListState()

    val vm = getViewModel<AuthViewModel>()

    val items by vm.items.observeAsState(emptyList())

    Column {
        RecycleCompose(
            items,
            state,
            Modifier.fillMaxSize().background(color = Color.Green),
            editTextAdapterDelegate(vm::onTextChange),
            textAdapterDelegate {  },
            buttonAdapterDelegate {  }
        )
    }
}
