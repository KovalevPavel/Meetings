package me.kovp.feature_profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import me.kovp.core_design.SpaceItemAdapterData
import me.kovp.core_design.delegate_adapter.ItemViewState
import me.kovp.core_design.delegate_adapter.LineDecorator
import me.kovp.feature_profile.delegates.ProfileHeaderAdapterData
import me.kovp.feature_profile.delegates.ProfileItemAdapterData
import me.kovp.navigation.AppRouter
import timber.log.Timber

interface ProfileViewModel {
    val items: LiveData<List<ItemViewState>>

    fun onProfileAvatarClick()
    fun onProfileItemClick(item: ProfileItemAdapterData)
}

class ProfileViewModelImpl(
    private val router: AppRouter
) : ProfileViewModel, ViewModel() {
    override val items = MutableLiveData<List<ItemViewState>>()

    override fun onProfileAvatarClick() {
        Timber.d("Navigate to cropping avatar")
    }

    override fun onProfileItemClick(item: ProfileItemAdapterData) {
        Timber.d("clicked -> $item")
    }

    init {
        items.value = listOf(
            ProfileHeaderAdapterData(
                id = "fff",
                avatarUrl = "https://upload.wikimedia.org/wikipedia/commons/9/9e/Domestic_cat.jpg",
                userName = "Ковалев Павел",
                userContact = "@pkovalev"
            ),
            SpaceItemAdapterData(height = me.kovp.core_design.R.dimen.margin_xxh),
            ProfileItemAdapterData(
                id = "",
                icon = R.drawable.ic_coins,
                decorator = LineDecorator(),
                title = "Профиль"
            ),
            ProfileItemAdapterData(
                id = "",
                icon = R.drawable.ic_coins,
                decorator = LineDecorator(),
                title = "Расходы"
            )
        )
    }
}