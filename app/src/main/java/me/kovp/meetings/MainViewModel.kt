package me.kovp.meetings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import me.kovp.core_auth.AuthHolder
import me.kovp.navigation.NavigationCommand
import me.kovp.navigation.NavigationCommand.Replace

interface MainViewModel {
    val navigationCommandLiveData: LiveData<NavigationCommand>
}

class MainViewModelImpl(
    private val authHolder: AuthHolder
) : MainViewModel, ViewModel() {
    override val navigationCommandLiveData = MutableLiveData<NavigationCommand>()

    init {
        viewModelScope.launch {
            delay(2000)
            val nextScreen = if (authHolder.token.isNullOrEmpty()) AuthScreen else MainHostScreen
            navigationCommandLiveData.value = Replace(screen = nextScreen)
        }
    }
}
