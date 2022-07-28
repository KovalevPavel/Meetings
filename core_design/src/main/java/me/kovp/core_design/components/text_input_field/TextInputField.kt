package me.kovp.core_design.components.text_input_field

import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.kovp.core_design.delegate_adapter.ItemViewState
import me.kovp.core_design.delegate_adapter.lazyColumnAdapterDelegate

@Composable
fun editTextAdapterDelegate(onTextChange: (EditTextVs) -> Unit) =
    lazyColumnAdapterDelegate<EditTextVs> {
        val text = remember { mutableStateOf(text) }

        EditTextCompose(
            text = text.value,
            hint = hint,
            textSize = textSize,
            keyboardType = keyboardType,
            onTextChange = {
                text.value = it
                this.text = it
                onTextChange(this)
            }
        )
    }

data class EditTextVs(
    override var id: String,
    var text: String = "",
    val hint: String = "",
    val textSize: TextUnit = 14.sp,
    val keyboardType: KeyBoardType = KeyBoardType.TEXT
) : ItemViewState

@Composable
fun EditTextCompose(
    text: String,
    hint: String,
    textSize: TextUnit,
    keyboardType: KeyBoardType,
    onTextChange: (String) -> Unit,
) {
    TextField(
        modifier = Modifier
            .defaultMinSize(minHeight = 24.dp)
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        keyboardOptions = KeyboardOptions(
            keyboardType = when (keyboardType) {
                KeyBoardType.TEXT -> KeyboardType.Text
                KeyBoardType.NUMBER -> KeyboardType.Number
                KeyBoardType.URI -> KeyboardType.Uri
            }
        ),
        shape = MaterialTheme.shapes.small,
        textStyle = TextStyle(
            fontSize = textSize,
            fontFamily = FontFamily.Default,
            letterSpacing = 0.sp,
        ),
        value = text,
        onValueChange = { onTextChange(it) },
        placeholder = { Text(fontSize = textSize, text = hint) }
    )
}
