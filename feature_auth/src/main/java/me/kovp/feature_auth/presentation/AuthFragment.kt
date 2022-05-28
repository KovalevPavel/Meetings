package me.kovp.feature_auth.presentation

import by.kirich1409.viewbindingdelegate.viewBinding
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import me.kovp.core_design.BaseFragment
import me.kovp.core_design.addSpaceItemDecoration
import me.kovp.core_design.defaultDecoratorProvider
import me.kovp.core_design.delegate_adapter.DefaultDifferConfig
import me.kovp.core_design.meetings_button.meetingsButtonAdapterDelegate
import me.kovp.core_design.textInputAdapterDelegate
import me.kovp.core_design.spaceItemDelegate
import me.kovp.feature_auth.R
import me.kovp.feature_auth.databinding.FragmentAuthBinding
import me.kovp.feature_auth.di.authModule
import org.koin.android.ext.android.inject
import org.koin.core.module.Module

class AuthFragment : BaseFragment(R.layout.fragment_auth) {
    override val moduleProvider: Module.() -> Unit = {
        authModule()
    }

    private val binding by viewBinding(FragmentAuthBinding::bind)
    private val viewModel: AuthViewModel by inject<AuthViewModelImpl>()

    private val itemsAdapter by lazy {
        AsyncListDifferDelegationAdapter(
            DefaultDifferConfig.config,
            spaceItemDelegate(),
            textInputAdapterDelegate(viewModel::onTextChange),
            meetingsButtonAdapterDelegate(viewModel::onButtonClick)
        )
    }

    override fun initUi() {
        binding.rvAuth.apply {
            adapter = itemsAdapter
            addSpaceItemDecoration(itemsAdapter.defaultDecoratorProvider)
        }
    }

    override fun initViewModelObservers() {
        viewModel.apply {
            title.observe(binding.tvAuthTitle::setText)
            items.observe(itemsAdapter::setItems)
        }
    }
}