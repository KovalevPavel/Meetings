package me.kovp.core_design.delegate_adapter

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.State

class SpaceItemDecoration(
    private val decoratorProvider: (Int) -> Decorator?
) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: State) {
        super.getItemOffsets(outRect, view, parent, state)
        val itemPosition = parent.getChildAdapterPosition(view)
        val decorator = decoratorProvider(itemPosition) as? SpaceDecorator ?: return
        val spaceValue = parent.context.resources.getDimensionPixelSize(decorator.space)

        outRect.set(0, spaceValue, 0, spaceValue)
    }
}