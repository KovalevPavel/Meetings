package me.kovp.feature_profile.domain

class GetMenuItemsInteractor(
    private val repo: ProfileRepository
) {
    suspend operator fun invoke() = repo.getProfileItemsList()
}