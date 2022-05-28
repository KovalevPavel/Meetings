package me.kovp.feature_profile.di

import me.kovp.feature_profile.data.ProfileRepositoryImpl
import me.kovp.feature_profile.domain.GetMenuItemsInteractor
import me.kovp.feature_profile.domain.GetProfileInfoInteractor
import me.kovp.feature_profile.domain.ProfileRepository
import me.kovp.feature_profile.presentation.ProfileScreenMapper
import me.kovp.feature_profile.presentation.ProfileViewModelImpl
import me.kovp.navigation.di.HostRouter
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module

fun Module.profileModule() {
    single<ProfileRepository> { ProfileRepositoryImpl(get()) }
    single { ProfileScreenMapper() }
    single { GetProfileInfoInteractor(get()) }
    single { GetMenuItemsInteractor(get()) }

    viewModel {
        ProfileViewModelImpl(
            router = get(qualifier = HostRouter),
            getProfileInfo = get(),
            getMenuItems = get(),
            mapper = get()
        )
    }
}