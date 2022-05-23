package me.kovp.core_design

import android.view.View

fun View.setOnClick(action: () -> Unit) {
    this.setOnClickListener { action() }
}
