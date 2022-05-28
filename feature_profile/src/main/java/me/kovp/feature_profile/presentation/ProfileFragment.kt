package me.kovp.feature_profile.presentation

import by.kirich1409.viewbindingdelegate.viewBinding
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import me.kovp.core_design.BaseFragment
import me.kovp.core_design.addLineItemDecoration
import me.kovp.core_design.defaultDecoratorProvider
import me.kovp.core_design.delegate_adapter.DefaultDifferConfig
import me.kovp.core_design.spaceItemDelegate
import me.kovp.feature_profile.R.layout
import me.kovp.feature_profile.databinding.FragmentProfileBinding
import me.kovp.feature_profile.di.profileModule
import me.kovp.feature_profile.presentation.delegates.profileHeaderDelegate
import me.kovp.feature_profile.presentation.delegates.profileItemDelegate
import org.koin.android.ext.android.inject
import org.koin.core.module.Module

class ProfileFragment : BaseFragment(layout.fragment_profile) {
    override val moduleProvider: Module.() -> Unit = {
        profileModule()
    }

    private val binding by viewBinding<FragmentProfileBinding>()
    private val viewModel: ProfileViewModel by inject<ProfileViewModelImpl>()
    private val itemsAdapter by lazy {
        AsyncListDifferDelegationAdapter(
            DefaultDifferConfig.config,
            profileHeaderDelegate(viewModel::onProfileAvatarClick),
            profileItemDelegate(viewModel::onProfileItemClick),
            spaceItemDelegate()
        )
    }

    override fun initUi() {
        binding.rvProfileItems.adapter = itemsAdapter
        binding.rvProfileItems.addLineItemDecoration(itemsAdapter.defaultDecoratorProvider)
    }

    override fun initViewModelObservers() {
        viewModel.items.observe(itemsAdapter::setItems)
    }
}