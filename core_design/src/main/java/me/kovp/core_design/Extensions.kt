package me.kovp.core_design

import android.graphics.Bitmap
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.Transformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import me.kovp.core_design.delegate_adapter.Decorator
import me.kovp.core_design.delegate_adapter.ItemViewState
import me.kovp.core_design.delegate_adapter.LineItemDecoration
import me.kovp.core_design.delegate_adapter.SpaceItemDecoration

val AsyncListDifferDelegationAdapter<ItemViewState>.defaultDecoratorProvider: (Int) -> Decorator?
    get() = { items[it]?.decorator }

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

fun RecyclerView.addSpaceItemDecoration(provider: (Int) -> Decorator?) {
    addItemDecoration(SpaceItemDecoration(provider))
}

fun RecyclerView.addLineItemDecoration(provider: (Int) -> Decorator?) {
    addItemDecoration(LineItemDecoration(provider))
}

