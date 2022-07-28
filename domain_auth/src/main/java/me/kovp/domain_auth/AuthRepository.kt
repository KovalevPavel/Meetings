package me.kovp.domain_auth

interface AuthRepository {
    suspend fun loginUser(userData: Map<String, String>): String
//    suspend fun sendMessage(message: String): String
}