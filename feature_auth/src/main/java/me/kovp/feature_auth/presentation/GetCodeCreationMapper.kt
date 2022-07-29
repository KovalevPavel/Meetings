package me.kovp.feature_auth.presentation

import me.kovp.core_design.components.text_field.TextVs
import me.kovp.core_design.components.text_input_field.EditTextVs
import me.kovp.core_design.delegate_adapter.ItemViewState

class GetCodeCreationMapper {
    fun map(): List<ItemViewState> = mutableListOf<ItemViewState>().apply {
        TextVs(
            id = ENTER_NICK_HEADER_ID,
            text = "Для входа в приложение введи свой ник в Телеграме",
        )
        EditTextVs(
            id = ENTER_NICK_FIELD_ID,
            hint = "@nickName"
        )
    }

    companion object {
        private const val ENTER_NICK_HEADER_ID = "ENTER_NICK_HEADER_ID"
        private const val ENTER_NICK_FIELD_ID = "ENTER_NICK_FIELD_ID"
    }
}