package me.kovp.core_design.delegate_adapter

import androidx.compose.runtime.Composable
import kotlin.reflect.KClass

interface ViewStateAdapterDelegate {

    fun isDelegateValid(itemToBind: ItemViewState): Boolean

    @Composable
    fun BindViewState(itemToBind: ItemViewState)
}