package me.kovp.feature_profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import me.kovp.core_design.delegate_adapter.ItemViewState
import me.kovp.feature_profile.delegates.ProfileItemAdapterData
import me.kovp.navigation.AppRouter
import timber.log.Timber

interface ProfileViewModel {
    val items: LiveData<List<ItemViewState>>
    fun onProfileItemClick(item: ProfileItemAdapterData)
}

class ProfileViewModelImpl(
    private val router: AppRouter
) : ProfileViewModel, ViewModel() {
    override val items = MutableLiveData<List<ItemViewState>>()

    override fun onProfileItemClick(item: ProfileItemAdapterData) {
        Timber.d("clicked -> $item")
    }

    init {
        items.value = listOf(
            ProfileItemAdapterData(
                icon = R.drawable.ic_coins,
                title = "Профиль"
            ),
            ProfileItemAdapterData(
                icon = R.drawable.ic_coins,
                title = "Расходы"
            )
        )
    }
}