package me.kovp.feature_profile.data

import me.kovp.feature_profile.domain.ProfileInfoVo
import me.kovp.feature_profile.domain.ProfileMenuItemVo
import me.kovp.feature_profile.domain.ProfileRepository

class ProfileRepositoryImpl : ProfileRepository {
    override suspend fun getProfileInfo(): ProfileInfoVo {
        return ProfileInfoVo(
            userName = "Павел Ковалев",
            userContact = "@pkovalev",
            userAvatar = "https://upload.wikimedia.org/wikipedia/commons/9/9e/Domestic_cat.jpg"
        )
    }

    override suspend fun getProfileItemsList(): List<ProfileMenuItemVo> =
        listOf(
            ProfileMenuItemVo(
                id = "profile_expenses_id",
                title = "Расходы"
            ),
            ProfileMenuItemVo(
                id = "profile_calendar_id",
                title = "Мой график"
            ),
            ProfileMenuItemVo(
                id = "profile_settings_id",
                title = "Настройки"
            ),
            ProfileMenuItemVo(
                id = "profile_logout_id",
                title = "Выход"
            )
        )
}