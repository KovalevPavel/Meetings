package me.kovp.meetings.feature_profile.domain

class GetProfileInfoInteractor(
    private val repo: ProfileRepository
) {
    suspend operator fun invoke() = repo.getProfileInfo()
}