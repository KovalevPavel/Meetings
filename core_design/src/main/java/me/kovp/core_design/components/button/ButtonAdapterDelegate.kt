package me.kovp.core_design.components.button

import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import me.kovp.core_design.components.button.ButtonVs.ButtonStyle.Progress
import me.kovp.core_design.components.button.ButtonVs.ButtonStyle.TextButton
import me.kovp.core_design.delegate_adapter.lazyColumnAdapterDelegate

fun buttonAdapterDelegate(onClick: (ButtonVs) -> Unit) = lazyColumnAdapterDelegate<ButtonVs> {
    Button(
        onClick = { onClick(this) },
        modifier = Modifier
            .fillMaxSize()
            .wrapContentHeight()
            .defaultMinSize(56.dp)
            .padding(horizontal = 16.dp),
        enabled = when (this.style) {
            is Progress -> false
            is TextButton -> this.style.isEnable
        },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = when(this.style) {
                is TextButton -> this.style.enableColor
                is Progress -> MaterialTheme.colors.primary
            },
            disabledBackgroundColor = when(this.style) {
                is TextButton -> this.style.disableColor
                Progress -> MaterialTheme.colors.onSurface.copy(alpha = 0.12f)
            },
        ),
    ) {
        when (this@lazyColumnAdapterDelegate.style) {
            Progress -> {
                CircularProgressIndicator()
            }
            is TextButton -> {
                Text(text = this@lazyColumnAdapterDelegate.style.text)
            }
        }
    }
}