package me.kovp.feature_profile.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import me.kovp.core_design.delegate_adapter.ItemViewState
import me.kovp.feature_profile.domain.GetMenuItemsInteractor
import me.kovp.feature_profile.domain.GetProfileInfoInteractor
import me.kovp.feature_profile.presentation.delegates.ProfileItemAdapterData
import me.kovp.navigation.AppRouter
import timber.log.Timber

interface ProfileViewModel {
    val items: LiveData<List<ItemViewState>>

    fun onProfileAvatarClick()
    fun onProfileItemClick(item: ProfileItemAdapterData)
}

class ProfileViewModelImpl(
    private val router: AppRouter,
    private val getProfileInfo: GetProfileInfoInteractor,
    private val getMenuItems: GetMenuItemsInteractor,
    private val mapper: ProfileScreenMapper,
) : ProfileViewModel, ViewModel() {
    override val items = MutableLiveData<List<ItemViewState>>()

    override fun onProfileAvatarClick() {
        Timber.d("Navigate to cropping avatar")
    }

    override fun onProfileItemClick(item: ProfileItemAdapterData) {
        Timber.d("clicked -> $item")
    }

    init {
        fetchProfileInfo()
    }

    private fun fetchProfileInfo() {
        viewModelScope.launch {
            mapper.map(
                profileInfo = getProfileInfo(),
                items = getMenuItems()
            )
                .let(items::postValue)
        }
    }
}