package me.kovp.core_design.components.button

import androidx.compose.ui.graphics.Color
import me.kovp.core_design.delegate_adapter.ItemViewState

data class ButtonVs(
    override val id: String,
    val style: ButtonStyle = ButtonStyle.Progress,
) : ItemViewState {
    sealed class ButtonStyle {
        object Progress : ButtonStyle()
        data class TextButton(
            override val enableColor: Color,
            override val disableColor: Color,
            val text: String,
            val isEnable: Boolean = true,
        ) : ButtonStyle(), ButtonColors
    }

    sealed interface ButtonColors {
        val enableColor: Color
        val disableColor: Color
    }
}