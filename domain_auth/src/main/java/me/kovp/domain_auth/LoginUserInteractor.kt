package me.kovp.domain_auth

class LoginUserInteractor(
    private val repo: AuthRepository,
    private val authHolder: AuthHolder
) {
    suspend operator fun invoke(userData: Map<String, String>) {
        repo.loginUser(userData = userData).also { authHolder.token = it }
    }
}