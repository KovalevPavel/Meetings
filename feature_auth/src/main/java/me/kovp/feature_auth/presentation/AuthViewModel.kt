package me.kovp.feature_auth.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import me.kovp.core_design.TextInputAdapterData
import me.kovp.core_design.delegate_adapter.ItemViewState
import me.kovp.core_design.meetings_button.MeetingsButtonAdapterData
import me.kovp.core_design.meetings_button.MeetingsButtonAdapterData.ButtonState
import me.kovp.feature_auth.domain.LoginUserInteractor
import me.kovp.feature_auth.domain.ValidateInputDataInteractor
import me.kovp.feature_auth.presentation.AuthScreenMapper.Companion.LOGIN_BUTTON_ID
import me.kovp.feature_auth.presentation.AuthScreenMapper.Companion.LOGIN_INPUT_ID
import me.kovp.feature_auth.presentation.AuthScreenMapper.Companion.PASSWORD_INPUT_ID
import timber.log.Timber

interface AuthViewModel {
    val title: LiveData<String>
    val items: LiveData<List<ItemViewState>>

    fun onTextChange(item: TextInputAdapterData)
    fun onButtonClick(button: MeetingsButtonAdapterData)
}

class AuthViewModelImpl(
    private val screenMapper: AuthScreenMapper,
    private val validateInputData: ValidateInputDataInteractor,
    private val loginUser: LoginUserInteractor
) : ViewModel(), AuthViewModel {
    override val title = MutableLiveData("Вход")
    override val items = MutableLiveData<List<ItemViewState>>()

    private val inputState = mutableMapOf(
        LOGIN_INPUT_ID to "",
        PASSWORD_INPUT_ID to ""
    )

    private val activeButton by lazy {
        MeetingsButtonAdapterData(
            id = LOGIN_BUTTON_ID,
            style = me.kovp.core_design.R.style.MeetingsButtonPrimaryActive,
            state = ButtonState(
                title = "Обмазаться",
                enabled = true
            )
        )
    }

    private val inactiveButton by lazy {
        MeetingsButtonAdapterData(
            id = LOGIN_BUTTON_ID,
            style = me.kovp.core_design.R.style.MeetingsButtonPrimaryInactive,
            state = ButtonState(
                title = "Обмазаться",
                enabled = false
            )
        )
    }

    init {
        fetchScreenData()
    }

    override fun onTextChange(item: TextInputAdapterData) {
        inputState[item.id] = item.text
        updateButtonState()
    }

    override fun onButtonClick(button: MeetingsButtonAdapterData) {
        when (button.id) {
            LOGIN_BUTTON_ID -> {
                viewModelScope.launch(Dispatchers.IO) {
                    loginUser(userData = inputState)
                        .let(Timber::d)
                }
            }
        }
    }

    private fun fetchScreenData() {
        screenMapper.map().let(items::postValue)
    }

    private fun updateButtonState() {
        val currentButtonState = items.value.orEmpty().lastOrNull() ?: return
        val newButtonState = if (validateInputData(inputState)) activeButton else activeButton
        if (currentButtonState != newButtonState) {
            items.value = items.value
                .orEmpty()
                .dropLast(1)
                .toMutableList()
                .apply { add(newButtonState) }
        }
    }
}