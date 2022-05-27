package me.kovp.feature_profile

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import by.kirich1409.viewbindingdelegate.viewBinding
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import me.kovp.core_design.BaseFragment
import me.kovp.core_design.addLineItemDecoration
import me.kovp.core_design.addSpaceItemDecoration
import me.kovp.core_design.defaultDecoratorProvider
import me.kovp.core_design.delegate_adapter.DefaultDifferConfig
import me.kovp.core_design.spaceItemDelegate
import me.kovp.feature_profile.databinding.FragmentProfileBinding
import me.kovp.feature_profile.delegates.profileHeaderDelegate
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