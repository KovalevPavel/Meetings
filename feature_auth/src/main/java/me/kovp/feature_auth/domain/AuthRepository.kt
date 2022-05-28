package me.kovp.feature_auth.domain

interface AuthRepository {
//    suspend fun loginUser(userData: Map<String, String>): String
    suspend fun sendMessage(message: String): String
}