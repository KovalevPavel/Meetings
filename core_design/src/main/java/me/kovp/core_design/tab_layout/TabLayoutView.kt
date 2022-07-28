package me.kovp.core_design.tab_layout

import android.content.Context
import android.util.AttributeSet
import com.google.android.material.tabs.TabLayout
import me.kovp.core_design.ItemViewStateListener

class TabLayoutView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : TabLayout(context, attrs, defStyleAttr) {
    var listener: ItemViewStateListener<TabItemAdapterData>? = null
    private var tabsData: List<TabItemAdapterData> = emptyList()

    init {
        addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: Tab?) {
                tab ?: return
                tabsData.getOrNull(tab.position)?.let { listener?.invoke(it) }
            }

            override fun onTabUnselected(tab: Tab?) = Unit

            override fun onTabReselected(tab: Tab?) = Unit

        })
    }

    fun applyViewState(state: TabLayoutAdapterData) {
        tabsData = state.tabs
        removeAllTabs()
        updateLayoutParams()
        state.tabs.forEach { tab ->
            addTab(
                newTab().apply {
                    text = tab.tabTitle
                    if (tab.tabIcon != 0) setIcon(tab.tabIcon)
                }
            )
        }
    }

    fun addNewTabs(tabs: List<TabItemAdapterData>) {
        removeAllTabs()
        tabsData = tabs
        updateLayoutParams()
        tabs.forEach { tab ->
            addTab(
                newTab().apply {
                    text = tab.tabTitle
                    if (tab.tabIcon != 0) setIcon(tab.tabIcon)
                }
            )
        }
    }

    private fun updateLayoutParams() {
        tabMode = if (tabsData.size > MAX_FIXED_TABS) MODE_SCROLLABLE else MODE_FIXED
    }

    companion object {
        private const val MAX_FIXED_TABS = 3
    }
}