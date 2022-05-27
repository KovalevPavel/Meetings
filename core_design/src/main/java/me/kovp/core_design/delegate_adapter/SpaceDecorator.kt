package me.kovp.core_design.delegate_adapter

import androidx.annotation.DimenRes
import me.kovp.core_design.R

data class SpaceDecorator(
    @DimenRes
    val space: Int = R.dimen.default_divider_space
) : Decorator