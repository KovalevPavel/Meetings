package me.kovp.meetings.feature_splash.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

interface SplashViewModel {
    val authInfoEvent: LiveData<Boolean>
}

class SplashViewModelImpl : ViewModel(), SplashViewModel {
    override val authInfoEvent = MutableLiveData<Boolean>()

    init {
        viewModelScope.launch {
            println("init view model")
            delay(2000)
            authInfoEvent.value = true
            println("called event")
        }
    }

    override fun onCleared() {
        println("cleared")
        super.onCleared()
    }
}