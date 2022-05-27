package me.kovp.feature_events

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import androidx.recyclerview.widget.RecyclerView.State
import by.kirich1409.viewbindingdelegate.viewBinding
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import me.kovp.core_design.BaseFragment
import me.kovp.core_design.addSpaceItemDecoration
import me.kovp.core_design.defaultDecoratorProvider
import me.kovp.core_design.delegate_adapter.DefaultDifferConfig
import me.kovp.core_design.spaceItemDelegate
import me.kovp.feature_events.databinding.FragmentEventsBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module

class EventsFragment : BaseFragment(R.layout.fragment_events) {
    override val moduleProvider: Module.() -> Unit = {
        viewModel { EventsViewModelImpl() }
    }

    private val binding by viewBinding(FragmentEventsBinding::bind)
    private val viewModel: EventsViewModel by inject<EventsViewModelImpl>()

    private val itemAdapter by lazy {
        AsyncListDifferDelegationAdapter(
            DefaultDifferConfig.config,
            eventCardDelegate { },
            spaceItemDelegate()
        )
    }

    override fun initUi() {
        binding.rvEventsList.adapter = itemAdapter
        binding.rvEventsList.addSpaceItemDecoration(itemAdapter.defaultDecoratorProvider)
    }

    override fun initViewModelObservers() {
        viewModel.items.observe(itemAdapter::setItems)
    }
}