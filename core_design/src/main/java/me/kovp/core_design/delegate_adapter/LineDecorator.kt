package me.kovp.core_design.delegate_adapter

import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import me.kovp.core_design.R

class LineDecorator(
    @DimenRes
    val widthInPx: Int = R.dimen.default_divider_width,
    @DimenRes
    val marginLeft: Int = R.dimen.default_divider_margin_left,
    @DimenRes
    val marginRight: Int = R.dimen.default_divider_margin_right,
    @ColorRes
    val lineColor: Int = R.color.blue
) : Decorator