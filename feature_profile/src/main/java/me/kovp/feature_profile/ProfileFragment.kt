package me.kovp.feature_profile

import by.kirich1409.viewbindingdelegate.viewBinding
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import me.kovp.core_design.BaseFragment
import me.kovp.core_design.delegate_adapter.DefaultDifferConfig
import me.kovp.feature_profile.databinding.FragmentProfileBinding
import me.kovp.feature_profile.delegates.profileItemDelegate
import me.kovp.navigation.di.HostRouter
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module

class ProfileFragment : BaseFragment(R.layout.fragment_profile) {
    override val moduleProvider: Module.() -> Unit = {
        viewModel {
            ProfileViewModelImpl(
                router = getKoin().get(qualifier = HostRouter)
            )
        }
    }

    private val binding by viewBinding<FragmentProfileBinding>()
    private val viewModel: ProfileViewModel by inject<ProfileViewModelImpl>()
    private val itemsAdapter by lazy {
        AsyncListDifferDelegationAdapter(
            DefaultDifferConfig.config,
            profileItemDelegate(viewModel::onProfileItemClick)
        )
    }

    override fun initUi() {
        binding.rvProfileItems.adapter = itemsAdapter
    }

    override fun initViewModelObservers() {
        viewModel.items.observe(itemsAdapter::setItems)
    }
}