package me.kovp.meetings

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import me.kovp.meetings.databinding.ActivityMainBinding
import me.kovp.navigation.AppRouter
import me.kovp.navigation.bindNavigation
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val binding by viewBinding(vbFactory = ActivityMainBinding::bind)

    private val viewModel: MainViewModel by viewModel<MainViewModelImpl>()
    private val router by inject<AppRouter>()

    override fun onCreate(savedInstanceState: Bundle?) {
        bindNavigation(R.id.fragmentContainerView)
        loadKoinModules(
            module {
                viewModel { MainViewModelImpl(authHolder = get()) }
            }
        )
        super.onCreate(savedInstanceState)
        viewModel.navigationCommandLiveData.observe(this) {
            router.handleNavigationCommand(it)
        }
    }
}

