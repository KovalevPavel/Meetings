package me.kovp.meetings.core

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

fun ViewModel.launch(
    body: suspend () -> Unit,
    error: (Exception) -> Unit = {},
    final: suspend () -> Unit = {}
) {
    viewModelScope.launch {
        try {
            body()
        } catch (e: Exception) {
            error(e)
        } finally {
            final()
        }
    }
}