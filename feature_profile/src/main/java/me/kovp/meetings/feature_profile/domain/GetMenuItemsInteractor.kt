package me.kovp.meetings.feature_profile.domain

class GetMenuItemsInteractor(
    private val repo: ProfileRepository
) {
    suspend operator fun invoke() = repo.getProfileItemsList()
}