package me.kovp.feature_auth.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import me.kovp.core_design.components.text_input_field.EditTextVs
import java.util.UUID
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import me.kovp.core_design.components.text_field.TextVs
import me.kovp.core_design.delegate_adapter.ItemViewState

class AuthViewModel : ViewModel() {

    val items: LiveData<List<ItemViewState>>
        get() = _items

    private val _items = MutableLiveData<List<ItemViewState>>()

    val inputText: LiveData<String>
        get() = _inputText

    private val _inputText = MutableLiveData<String>()

    init {
        viewModelScope.launch {
            _items.value = listOf(
                EditTextVs(
                    id = TEXT_INPUT_ID,
                    hint = "hint",
                ),
                TextVs(
                    id = "",
                )
            )
        }

    }

    fun onTextChange(editVs: EditTextVs) {
        when (editVs.id) {
            TEXT_INPUT_ID -> {
                _inputText.value = editVs.text
            }
        }
    }

    companion object {
        internal const val TEXT_INPUT_ID = "TEXT_INPUT_ID"
    }
}