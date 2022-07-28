package me.kovp.meetings.feature_splash

import me.kovp.meetings.feature_splash.presentation.SplashViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun splashModule() = module {
    viewModel { SplashViewModelImpl() }
}