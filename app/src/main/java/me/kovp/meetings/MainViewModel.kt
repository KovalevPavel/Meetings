package me.kovp.meetings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import me.kovp.navigation.NavigationCommand
import me.kovp.navigation.NavigationCommand.Replace

interface MainViewModel {
    val navigationCommandLiveData: LiveData<NavigationCommand>
}

class MainViewModelImpl : MainViewModel, ViewModel() {
    override val navigationCommandLiveData = MutableLiveData<NavigationCommand>()

    init {
        viewModelScope.launch {
            delay(2000)
            navigationCommandLiveData.value = Replace(screen = MainHostScreen)
        }
    }
}
