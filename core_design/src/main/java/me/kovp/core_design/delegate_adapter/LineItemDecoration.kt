package me.kovp.core_design.delegate_adapter

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Paint.Style
import android.graphics.Rect
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.view.forEach
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.State

class LineItemDecoration(
    private val decoratorProvider: (Int) -> Decorator?
) : RecyclerView.ItemDecoration() {
    private val linePaint = Paint().apply { style = Style.FILL }

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: State) {
        super.getItemOffsets(outRect, view, parent, state)
        val decorator = getDecorator(parent, view) ?: return

        outRect.bottom = parent.context.resources.getDimensionPixelSize(decorator.widthInPx)
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: State) {
        super.onDraw(c, parent, state)
        parent.forEach { child ->
            val decorator = getDecorator(parent, child)
            val params = child.layoutParams as RecyclerView.LayoutParams

            decorator?.let {
                val itemStrokeWidth =
                    parent.context.resources.getDimensionPixelSize(decorator.widthInPx).toFloat()
                val strokeWidthOffset = itemStrokeWidth / 2
                val itemMarginLeft =
                    parent.context.resources.getDimensionPixelSize(decorator.marginLeft)
                val itemMarginRight =
                    parent.context.resources.getDimensionPixelSize(decorator.marginRight)

                val startX =
                    parent.paddingLeft + itemMarginLeft + child.translationX.toInt()
                val endX =
                    parent.width - parent.paddingRight - itemMarginRight + child.translationX.toInt()
                val y =
                    child.bottom + params.bottomMargin + child.translationY.toInt() + strokeWidthOffset.toInt()

                linePaint.apply {
                    color = ContextCompat.getColor(parent.context, decorator.lineColor)
                    strokeWidth = itemStrokeWidth
                }

                c.drawLine(startX.toFloat(), y.toFloat(), endX.toFloat(), y.toFloat(), linePaint)
            }
        }
    }

    private fun getDecorator(recyclerView: RecyclerView, view: View): LineDecorator? {
        val position = recyclerView.getChildAdapterPosition(view)
        if (position == -1) return null

        return decoratorProvider(position) as? LineDecorator
    }
}