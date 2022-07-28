package me.kovp.meetings.feature_splash

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import me.kovp.meetings.feature_splash.presentation.SplashViewModel
import me.kovp.meetings.feature_splash.presentation.SplashViewModelImpl
import org.koin.androidx.compose.getViewModel
import org.koin.androidx.compose.viewModel
import org.koin.core.context.loadKoinModules

@Composable
fun SplashCompose(
    onLoadComplete: () -> Unit
) {
    loadKoinModules(splashModule())
    val vm: SplashViewModel = getViewModel<SplashViewModelImpl>()
    val state by vm.authInfoEvent.observeAsState(false)
    SplashContent(
        loadComplete = state,
        onLoadComplete = onLoadComplete,
        hash = vm.hashCode()
    )
}

@Composable
fun SplashContent(
    loadComplete: Boolean,
    onLoadComplete: () -> Unit,
    hash: Int,
) {
    when (loadComplete) {
        true -> onLoadComplete()
        false -> Text("Splash $hash")
    }
}