package me.kovp.feature_auth.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import me.kovp.core_design.components.text_input_field.EditTextVs
import java.util.UUID

class AuthViewModel : ViewModel() {

    val items: LiveData<List<EditTextVs>>
        get() = _items

    private val _items = MutableLiveData<List<EditTextVs>>()

    val inputText: LiveData<String>
        get() = _inputText

    private val _inputText = MutableLiveData<String>()

    init {
        _items.value = listOf(
            EditTextVs(
                id = TEXT_INPUT_ID,
                hint = "hint",
            ),
            EditTextVs(
                id = UUID.randomUUID().toString(),
                hint = "hint",
            )
        )
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