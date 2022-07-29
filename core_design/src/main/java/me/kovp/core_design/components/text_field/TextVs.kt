package me.kovp.core_design.components.text_field

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import me.kovp.core_design.delegate_adapter.ItemViewState

data class TextVs(
    override val id: String,
    val text: String = "",
    val textSize: TextUnit = 15.sp,
    val textColor: Color = Color.White,
    val textAlign: TextAlign = TextAlign.Start,
    val clickable: Boolean = false,
    val textStyle: TextStyle = TextStyle(),
) : ItemViewState {
    data class TextStyle(
        val isBold: Boolean = false,
        val isItalic: Boolean = false,
    )
}
