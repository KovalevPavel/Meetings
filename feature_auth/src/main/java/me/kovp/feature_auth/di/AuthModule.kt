package me.kovp.feature_auth.di

import me.kovp.feature_auth.data.AuthRepositoryImpl
import me.kovp.feature_auth.domain.AuthRepository
import me.kovp.feature_auth.domain.LoginUserInteractor
import me.kovp.feature_auth.domain.ValidateInputDataInteractor
import me.kovp.feature_auth.presentation.AuthScreenMapper
import me.kovp.feature_auth.presentation.AuthViewModelImpl
import me.kovp.feature_network.di.Bot
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module

fun Module.authModule() {
    single<AuthRepository> { AuthRepositoryImpl(botApi = get()) }
    single { AuthScreenMapper() }
    single { ValidateInputDataInteractor() }
    single { LoginUserInteractor(repo = get(), authHolder = get()) }

    viewModel {
        AuthViewModelImpl(
            screenMapper = get(),
            validateInputData = get(),
            loginUser = get()
        )
    }
}