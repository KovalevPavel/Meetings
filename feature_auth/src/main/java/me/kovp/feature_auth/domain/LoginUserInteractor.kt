package me.kovp.feature_auth.domain

import me.kovp.core_auth.AuthHolder
import me.kovp.feature_network.okhttp.OkHttpClientProvider

class LoginUserInteractor(
    private val repo: AuthRepository,
    private val authHolder: AuthHolder
) {
//    suspend operator fun invoke(userData: Map<String, String>) {
//                repo.loginUser(userData = userData)
//                    .also { authHolder.token = it }
//    }

    suspend operator fun invoke(userData: Map<String, String>): String {
        return repo.sendMessage("test")
    }
}