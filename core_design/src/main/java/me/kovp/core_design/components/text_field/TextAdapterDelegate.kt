package me.kovp.core_design.components.text_field

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import me.kovp.core_design.delegate_adapter.lazyColumnAdapterDelegate

fun textAdapterDelegate(onClick: (TextVs) -> Unit) = lazyColumnAdapterDelegate<TextVs> {
    StaticTextCompose(item = this, onClick = onClick)
}

@Composable
fun StaticTextCompose(item: TextVs, onClick: (TextVs) -> Unit) {

    Text(
        text = item.text,
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxSize()
            .clickable { if (item.clickable) onClick(item) },
        color = item.textColor,
        fontSize = item.textSize,
        fontFamily = FontFamily.SansSerif
    )
}