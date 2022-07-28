package me.kovp.meetings.feature_events.presentation

import by.kirich1409.viewbindingdelegate.viewBinding
import me.kovp.core_design.BaseFragment
import me.kovp.core_design.ItemViewStateListener
import me.kovp.feature_events.R.layout
import me.kovp.feature_events.databinding.FragmentEventsBinding
import org.koin.android.ext.android.inject
import org.koin.core.module.Module

class EventsFragment : BaseFragment(layout.fragment_events) {
    override val moduleProvider: Module.() -> Unit = {

    }

    private val binding by viewBinding(FragmentEventsBinding::bind)
    private val viewModel: EventsViewModel by inject<EventsViewModelImpl>()
    private val onTabSelectedListener by lazy {
        ItemViewStateListener(viewModel::onTabSelected)
    }
}