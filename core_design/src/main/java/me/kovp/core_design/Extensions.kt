package me.kovp.core_design

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

fun View.setOnClick(action: () -> Unit) {
    this.setOnClickListener { action() }
}

fun ImageView.load(url: String, radius: Int = 0) {
    val corners = RoundedCorners(radius)
    Glide.with(this)
        .load(url)
        .transform(CenterCrop(), corners)
        .into(this)
}
