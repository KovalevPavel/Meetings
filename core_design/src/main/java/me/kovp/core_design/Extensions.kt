package me.kovp.core_design

import android.graphics.Bitmap
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.Transformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners


fun View.setOnClick(action: () -> Unit) {
    this.setOnClickListener { action() }
}

fun ImageView.load(url: String, radius: Int = 0) {
    val transformList = mutableListOf<Transformation<Bitmap>>()
        .apply {
            CenterCrop().let(::add)

            if (radius > 0) {
                RoundedCorners(radius).let(::add)
            }
        }
        .toTypedArray()

    Glide.with(this)
        .load(url)
        .transform(*transformList)
        .into(this)
}

