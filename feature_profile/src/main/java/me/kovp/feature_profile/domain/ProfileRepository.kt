package me.kovp.feature_profile.domain

interface ProfileRepository {
    suspend fun getProfileInfo(): ProfileInfoVo
    suspend fun getProfileItemsList(): List<ProfileMenuItemVo>
}