package me.kovp.feature_auth.data

import me.kovp.domain_auth.AuthRepository
import me.kovp.feature_network.api.AuthApi

class AuthRepositoryImpl(
    private val api: AuthApi,
) : AuthRepository {
    override suspend fun loginUser(userData: Map<String, String>): String {
        return "login"
    }
}