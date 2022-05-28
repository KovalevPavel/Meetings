package me.kovp.feature_auth.presentation

import me.kovp.core_design.SpaceItemAdapterData
import me.kovp.core_design.TextInputAdapterData
import me.kovp.core_design.delegate_adapter.ItemViewState
import me.kovp.core_design.meetings_button.MeetingsButtonAdapterData
import me.kovp.core_design.meetings_button.MeetingsButtonAdapterData.ButtonState

class AuthScreenMapper {
    fun map() = mutableListOf<ItemViewState>().apply {
        SpaceItemAdapterData(height = me.kovp.core_design.R.dimen.margin_h).let(::add)
        TextInputAdapterData(
            id = LOGIN_INPUT_ID,
            hint = "Введи логин"
        )
            .let(::add)

        TextInputAdapterData(
            id = PASSWORD_INPUT_ID,
            hint = "Введи пароль"
        )
            .let(::add)

        MeetingsButtonAdapterData(
            id = LOGIN_BUTTON_ID,
            style = me.kovp.core_design.R.style.MeetingsButtonPrimaryInactive,
            state = ButtonState(
                title = "Обмазаться",
                enabled = false
            )
        ).let(::add)
    }

    companion object {
        const val LOGIN_INPUT_ID = "LOGIN_INPUT_ID"
        const val PASSWORD_INPUT_ID = "PASSWORD_INPUT_ID"
        const val LOGIN_BUTTON_ID = "LOGIN_BUTTON_ID"
    }
}