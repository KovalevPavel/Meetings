package me.kovp.feature_auth.di

import me.kovp.domain_auth.AuthRepository
import me.kovp.domain_auth.LoginUserInteractor
import me.kovp.domain_auth.ValidateInputDataInteractor
import me.kovp.feature_auth.data.AuthRepositoryImpl
import me.kovp.feature_auth.presentation.AuthViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun authModule() = module {
    single<AuthRepository> { AuthRepositoryImpl(api = get()) }
    single { ValidateInputDataInteractor() }
    single { LoginUserInteractor(repo = get(), authHolder = get()) }

    viewModel { AuthViewModel() }
}