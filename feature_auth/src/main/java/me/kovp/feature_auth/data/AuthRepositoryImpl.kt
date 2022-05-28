package me.kovp.feature_auth.data

import me.kovp.feature_auth.domain.AuthRepository
import me.kovp.feature_auth.presentation.AuthScreenMapper.Companion.LOGIN_INPUT_ID
import me.kovp.feature_auth.presentation.AuthScreenMapper.Companion.PASSWORD_INPUT_ID
import me.kovp.feature_network.api.AuthApi
import me.kovp.feature_network.api.BotApi

class AuthRepositoryImpl(
//    private val api: AuthApi,
    private val botApi: BotApi
) : AuthRepository {
//    override suspend fun loginUser(userData: Map<String, String>): String = api
//        .loginUser(
//            userLogin = userData[LOGIN_INPUT_ID].orEmpty(),
//            userPassword = userData[PASSWORD_INPUT_ID].orEmpty()
//        )
//        .token
//        .orEmpty()

    override suspend fun sendMessage(message: String): String {
        return botApi.sendMessage(chatId = 418406076, text = "test")
//        return ""
    }
}