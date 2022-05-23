package me.kovp.main_host

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import me.kovp.core_design.BaseFragment
import me.kovp.main_host.databinding.FragmentMainHostBinding
import me.kovp.navigation.bindNavigation
import me.kovp.navigation.di.HostRouter
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module

class MainHostFragment : BaseFragment(R.layout.fragment_main_host) {
    override val moduleProvider: Module.() -> Unit = {
        viewModel { MainHostViewModelImpl() }

    }

    private val binding by viewBinding<FragmentMainHostBinding>()
    private val viewModel: MainHostViewModel by viewModels<MainHostViewModelImpl>()

    override fun onCreate(savedInstanceState: Bundle?) {
        bindNavigation(id = R.id.fcvMainHostContainer, qualifier = HostRouter)
        super.onCreate(savedInstanceState)
    }

    override fun initUx() {
        binding.bnvMainHostNavigation.setupWithNavController(
            navController = (
                    childFragmentManager
                        .findFragmentById(R.id.fcvMainHostContainer) as NavHostFragment
                    )
                .findNavController()
        )
    }
}
