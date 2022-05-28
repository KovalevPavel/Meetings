package me.kovp.feature_profile.presentation

import me.kovp.core_design.SpaceItemAdapterData
import me.kovp.core_design.delegate_adapter.ItemViewState
import me.kovp.core_design.delegate_adapter.LineDecorator
import me.kovp.feature_profile.R
import me.kovp.feature_profile.domain.ProfileInfoVo
import me.kovp.feature_profile.domain.ProfileMenuItemVo
import me.kovp.feature_profile.presentation.delegates.ProfileHeaderAdapterData
import me.kovp.feature_profile.presentation.delegates.ProfileItemAdapterData
import java.util.UUID

class ProfileScreenMapper {
    fun map(profileInfo: ProfileInfoVo, items: List<ProfileMenuItemVo>) =
        mutableListOf<ItemViewState>()
            .apply {
                mapProfileInfo(info = profileInfo).let(::add)
                SpaceItemAdapterData(height = me.kovp.core_design.R.dimen.margin_xxh).let(::add)
                items.map(::mapProfileItem).let(::addAll)
            }

    private fun mapProfileInfo(info: ProfileInfoVo) = ProfileHeaderAdapterData(
        id = UUID.randomUUID().toString(),
        avatarUrl = info.userAvatar,
        userName = info.userName,
        userContact = info.userContact
    )

    private fun mapProfileItem(item: ProfileMenuItemVo) = ProfileItemAdapterData(
        id = item.id,
        decorator = LineDecorator(),
        icon = mapIcon(item.id),
        title = item.title
    )

    private fun mapIcon(itemId: String) = when (itemId) {
        PROFILE_EXPENSES_ID -> R.drawable.ic_coins
        PROFILE_CALENDAR_ID -> R.drawable.ic_calendar
        PROFILE_SETTINGS_ID -> R.drawable.ic_settings
        PROFILE_LOGOUT_ID -> R.drawable.ic_logout
        else -> 0
    }

    companion object {
        private const val PROFILE_EXPENSES_ID = "profile_expenses_id"
        private const val PROFILE_CALENDAR_ID = "profile_calendar_id"
        private const val PROFILE_SETTINGS_ID = "profile_settings_id"
        private const val PROFILE_LOGOUT_ID = "profile_logout_id"
    }
}