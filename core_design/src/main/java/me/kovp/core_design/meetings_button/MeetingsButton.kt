package me.kovp.core_design.meetings_button

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.appcompat.view.ContextThemeWrapper
import com.google.android.material.button.MaterialButton
import me.kovp.core_design.R
import me.kovp.core_design.setOnClick

class MeetingsButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    var viewState: MeetingsButtonAdapterData = MeetingsButtonAdapterData()
        set(value) {
            if (value != field) {
                applyButtonStyle(value)
                field = value
            }
        }

    var listener: (MeetingsButtonAdapterData) -> Unit = {}

    private var button: MaterialButton? = null

    init {
        inflate(context, R.layout.view_meetings_button, this)
    }

    private fun applyButtonStyle(viewState: MeetingsButtonAdapterData) {
        button?.let(::removeView)
        createButton(viewState = viewState)
            .let {
                addView(it)
                button = it
            }
    }

    private fun createButton(viewState: MeetingsButtonAdapterData): MaterialButton {
        val buttonContext = ContextThemeWrapper(context, viewState.style)
        return MaterialButton(buttonContext, null, R.attr.button_style).apply {
            text = viewState.state.title
            this.isEnabled = viewState.state.enabled
            setOnClick { listener(viewState) }
            layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
        }
    }
}