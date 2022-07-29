package me.kovp.core_design.components.text_input_field

import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import me.kovp.core_design.components.text_input_field.KeyBoardType.TEXT
import me.kovp.core_design.delegate_adapter.ItemViewState

data class EditTextVs(
    override var id: String,
    var text: String = "",
    val hint: String = "",
    val textSize: TextUnit = 14.sp,
    val keyboardType: KeyBoardType = TEXT
) : ItemViewState